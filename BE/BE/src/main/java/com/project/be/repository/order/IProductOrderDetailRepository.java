package com.project.be.repository.order;

import com.project.be.model.order.ProductOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProductOrderDetailRepository extends JpaRepository<ProductOrderDetail, Integer> {
    @Modifying
    @Query(
            value = " UPDATE `hudagon_music`.`product_order_detail` " +
                    " SET `quantity` = :new_quantity " +
                    " WHERE (`id` = :product_order_id ) ",
            nativeQuery = true
    )
    void updateProductOrderDetail(
            @Param("new_quantity") String newQuantity,
            @Param("product_order_id") String productOrderId);


    @Modifying
    @Query(
            value = " delete from `hudagon_music`.`product_order_detail` " +
                    " where (`id` = :product_order_detail_id ) ",
            nativeQuery = true
    )
    void removeFromCart(
            @Param("product_order_detail_id") String productOrderDetailId
    );


}
