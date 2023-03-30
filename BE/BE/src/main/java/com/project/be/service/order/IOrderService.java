package com.project.be.service.order;

import com.project.be.dto.order.ProductOrderDto;
import com.project.be.model.order.ProductOrder;
import com.project.be.payload.request.TotalMoney;
import com.project.be.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService extends IGeneralService<ProductOrder> {

    ProductOrder getOrderByUserId(Integer userId);

    void saveManually(ProductOrderDto productOrderDto);

    void addProductOrderDetail(String productOrderId, String productQuantity, String productId);

    void updateTotalMoney(TotalMoney totalMoney);

    void updatePaymentStatus(String productOrderId);

    Page<ProductOrder> getProductOrderHistory(String productOrderId, Pageable pageable);

}
