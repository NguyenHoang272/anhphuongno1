package com.project.be.service.product_order_detail;

import com.project.be.model.order.ProductOrderDetail;
import com.project.be.service.IGeneralService;

public interface IProductOrderDetailService extends IGeneralService<ProductOrderDetail> {

    void updateProductOrderDetail(String newQuantity, String productOrderId);

    void removeFromCart(String productOrderDetailId);

}
