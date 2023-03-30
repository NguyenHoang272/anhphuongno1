package com.project.be.service.order;

import com.project.be.dto.order.ProductOrderDto;
import com.project.be.model.order.ProductOrder;
import com.project.be.payload.request.TotalMoney;
import com.project.be.repository.order.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Iterable<ProductOrder> findAll() {
        return null;
    }

    @Override
    public Optional<ProductOrder> findById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public ProductOrder save(ProductOrder productOrder) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
    @Override
    public ProductOrder getOrderByUserId(Integer userId) {
        return orderRepository.getOrderByUserId(userId);
    }

    @Override
    public void saveManually(ProductOrderDto productOrderDto) {
        orderRepository.saveManually(
                String.valueOf(productOrderDto.getDeleteStatus()),
                productOrderDto.getOrderDate(),
                String.valueOf(productOrderDto.getUserId()),
                String.valueOf(productOrderDto.getPaymentStatus()),
                String.valueOf(productOrderDto.getTotalMoney())
        );
    }

    @Override
    public void addProductOrderDetail(String productOrderId, String productQuantity, String productId) {
        orderRepository.addProductOrderDetail(productOrderId, productQuantity, productId);
    }

    @Override
    public void updateTotalMoney(TotalMoney totalMoney) {
        orderRepository.updateTotalMoney(
                String.valueOf(totalMoney.getOrderId()),
                String.valueOf(totalMoney.getTotalMoney()));
    }

    @Override
    public void updatePaymentStatus(String productOrderId) {
        orderRepository.updatePaymentStatus(productOrderId);
    }

    @Override
    public Page<ProductOrder> getProductOrderHistory(String productOrderId, Pageable pageable) {
        return orderRepository.getProductOrderHistory(productOrderId, pageable);
    }

}
