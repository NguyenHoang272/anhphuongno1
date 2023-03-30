package com.project.be.service.product;

import com.project.be.payload.request.ProductSearchInfo;
import com.project.be.model.product.Product;
import com.project.be.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<Product> searchProduct(ProductSearchInfo productSearchInfo, Pageable pageable) {

        String[] price = productSearchInfo.getPriceRange().split("-");

        String firstPrice = price[0];
        String lastPrice = price[1];

        return productRepository.searchProduct(
                productSearchInfo.getBrandId(),
                productSearchInfo.getCategoryId(),
                productSearchInfo.getProductName(),
                firstPrice, lastPrice,
                pageable);
    }
}
