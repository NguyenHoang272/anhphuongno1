package com.project.be.repository.product;

import com.project.be.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(
            value = " select * " +
                    " from product " +
                    " where name like %:product_name% and if ( :brand_id > 0, brand_id = :brand_id , brand_id > 0) " +
                    "           and if ( :category_id > 0, category_id = :category_id , category_id > 0) " +
                    "           and price between :first_price and :second_price "
            , nativeQuery = true
    )
    Page<Product> searchProduct(
            @Param("brand_id") String brandId,
            @Param("category_id") String categoryId,
            @Param("product_name") String productName,
            @Param("first_price") String firstPrice,
            @Param("second_price") String secondPrice,
            Pageable pageable);


}
