package com.project.be.controller.order;

import com.project.be.dto.order.ProductOrderDto;
import com.project.be.model.order.ProductOrder;
import com.project.be.model.order.ProductOrderDetail;

import com.project.be.payload.request.TotalMoney;

import com.project.be.service.order.IOrderService;
import com.project.be.service.product.IProductService;
import com.project.be.service.product_order_detail.IProductOrderDetailService;
import com.project.be.util.GetDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/productOrder")
public class ProductOrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductOrderDetailService productOrderDetailService;

    @GetMapping("/getProductOrder")
    public ResponseEntity<ProductOrder> getProductOrderByUserId(
            @RequestParam String userId
    ) {

        ProductOrder productOrderFound = orderService.getOrderByUserId(Integer.valueOf(userId));

        if (productOrderFound == null) {
            ProductOrderDto newProductOrderDto = new ProductOrderDto();
            newProductOrderDto.setOrderDate(GetDate.getCurrentDate());
            newProductOrderDto.setUserId(Integer.valueOf(userId));
            newProductOrderDto.setDeleteStatus(1);
            newProductOrderDto.setPaymentStatus(1);
            newProductOrderDto.setTotalMoney(0L);

            orderService.saveManually(newProductOrderDto);

            ProductOrder productOrderNew = orderService.getOrderByUserId(Integer.valueOf(userId));

            return new ResponseEntity<>(productOrderNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(productOrderFound, HttpStatus.OK);
    }

    @GetMapping("/addProductToCart")
    public ResponseEntity<Void> addProductToCart(
            @RequestParam String productOrderId,
            @RequestParam String productQuantity,
            @RequestParam String productId
    ) {

        Optional<ProductOrder> productOrder = orderService.findById(Integer.valueOf(productOrderId));

        if (productOrder.isPresent()) {
            ProductOrder productOrderFound = productOrder.get();

            List<ProductOrderDetail> productOrderDetailList = new ArrayList<>();
            productOrderDetailList = productOrderFound.getProductOrderDetailSet();

            for (ProductOrderDetail x : productOrderDetailList) {
                if (x.getProduct().getId() == Integer.parseInt(productId)) {

                    Integer oldQuantity = x.getQuantity();
                    Integer newQuantity = oldQuantity + Integer.parseInt(productQuantity);

                    productOrderDetailService.updateProductOrderDetail(String.valueOf(newQuantity),
                            String.valueOf(x.getId()));

                    return new ResponseEntity<>(HttpStatus.OK);
                }
            }

        }

        orderService.addProductOrderDetail(productOrderId, productQuantity, productId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/updateTotalMoney")
    public ResponseEntity<Void> updateTotalMoney(
            @RequestBody TotalMoney totalMoney
    ) {

        orderService.updateTotalMoney(totalMoney);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/updatePaymentStatus")
    public ResponseEntity<Void> updatePaymentStatus(
            @RequestBody String productOrderId
    ) {

        orderService.updatePaymentStatus(productOrderId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getOrderHistory/{userId}/{page}")
    public ResponseEntity<?> getOrderHistory(
            @PathVariable String userId,
            @PathVariable String page,
            @PageableDefault(value = 3) Pageable pageable
    ) {

        pageable = PageRequest.of(Integer.parseInt(page), 3);

        Page<ProductOrder> productOrdersPage = orderService.getProductOrderHistory(userId, pageable);

        return new ResponseEntity<>(productOrdersPage, HttpStatus.OK);
    }

    @PostMapping("/removeFromCart")
    public ResponseEntity<?> removeFromCart(
            @RequestBody String productOrderDetailId
    ) {

        productOrderDetailService.removeFromCart(productOrderDetailId);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
