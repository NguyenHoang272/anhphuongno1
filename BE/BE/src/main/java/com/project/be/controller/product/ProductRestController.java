package com.project.be.controller.product;

import com.project.be.dto.product.ProductHomeShow;
import com.project.be.model.product.*;
import com.project.be.payload.request.ProductSearchInfo;
import com.project.be.dto.product.ProductDetailInfoDto;
import com.project.be.payload.response.ProductDetailInfoResponse;
import com.project.be.service.product.IProductService;
import com.project.be.util.ConvertObjectToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/product")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @PostMapping("/searchProduct")
    public ResponseEntity<Page<ProductHomeShow>> getProductPage(
            @RequestBody ProductSearchInfo productSearchInfo,
            @PageableDefault(value = 2) Pageable pageable
            ) {

        switch (productSearchInfo.getSortByPrice()) {
            case "desc":
                pageable = PageRequest.of(Integer.parseInt(productSearchInfo.getPageNumber()),
                        Integer.parseInt(productSearchInfo.getPageSize()),
                        Sort.by("price").descending()
                );
                break;
            case "asc":
                pageable = PageRequest.of(Integer.parseInt(productSearchInfo.getPageNumber()),
                        Integer.parseInt(productSearchInfo.getPageSize()),
                        Sort.by("price").ascending()
                );
                break;
            default:
                pageable = PageRequest.of(Integer.parseInt(productSearchInfo.getPageNumber()),
                        Integer.parseInt(productSearchInfo.getPageSize())
                );
        }

        Page<Product> productPage = productService.searchProduct(productSearchInfo, pageable);

        List<ProductHomeShow> productHomeShowList = new ArrayList<>();

        for (Product x : productPage) {
            ProductHomeShow productHomeShow = new ProductHomeShow();

            productHomeShow.setId(x.getId());
            productHomeShow.setName(x.getName());
            productHomeShow.setBrand(x.getBrand().getName());
            productHomeShow.setCategory(x.getCategory().getName());
            productHomeShow.setPrice(x.getPrice());

            for (ImgUrlProduct y : x.getImgUrlProductList()) {
                productHomeShow.setHomeImgCart(y.getUrl());
                break;
            }

            productHomeShowList.add(productHomeShow);
        }

        Page<ProductHomeShow> productHomeShowPage = new PageImpl<>(productHomeShowList,
                pageable, productPage.getTotalElements());

        return new ResponseEntity<>(productHomeShowPage, HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ProductDetailInfoResponse> getProductById(
            @PathVariable String id) {

        Optional<Product> productFound = productService.findById(Integer.valueOf(id));
        Map<String, Object> productDetailMap = null;
        List<ProductDetailInfoDto> productDetailInfoDtoList = new ArrayList<>();

        if (productFound.isPresent()) {

            if (productFound.get().getGuitar() != null) {
                Guitar guitar =  productFound.get().getGuitar();
                productDetailMap = ConvertObjectToMap.convert(guitar);
            }

            if (productFound.get().getPiano() != null) {
                Piano piano =  productFound.get().getPiano();
                productDetailMap = ConvertObjectToMap.convert(piano);
            }

            assert productDetailMap != null;
            for (String x : productDetailMap.keySet()) {

                if (productDetailMap.get(x) != null &
                        !(productDetailMap.get(x) instanceof Product) &
                        !(productDetailMap.get(x) instanceof Integer)) {

                    productDetailInfoDtoList.add(new ProductDetailInfoDto(x, (String) productDetailMap.get(x)));
                }
            }

            return new ResponseEntity<>(new ProductDetailInfoResponse(productFound.get(), productDetailInfoDtoList),
                    HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}
