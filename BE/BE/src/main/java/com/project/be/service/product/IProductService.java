package com.project.be.service.product;

import com.project.be.payload.request.ProductSearchInfo;
import com.project.be.model.product.Product;
import com.project.be.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {

    Page<Product> searchProduct(
            ProductSearchInfo productSearchInfo,
                             Pageable pageable);

}
