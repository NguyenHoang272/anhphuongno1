package com.project.be.service.product_order_detail;

import com.project.be.model.order.ProductOrderDetail;
import com.project.be.repository.order.IProductOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductOrderDetailServiceImpl implements IProductOrderDetailService {

    @Autowired
    private IProductOrderDetailRepository productOrderDetailRepository;

    @Override
    public Iterable<ProductOrderDetail> findAll() {
        return null;
    }

    @Override
    public Optional<ProductOrderDetail> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public ProductOrderDetail save(ProductOrderDetail productOrderDetail) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void updateProductOrderDetail(String newQuantity, String productOrderId) {
        productOrderDetailRepository.updateProductOrderDetail(newQuantity, productOrderId);
    }

    @Override
    public void removeFromCart(String productOrderDetailId) {
        productOrderDetailRepository.removeFromCart(productOrderDetailId);
    }
}
