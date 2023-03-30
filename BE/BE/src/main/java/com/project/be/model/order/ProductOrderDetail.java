package com.project.be.model.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.be.model.product.Product;

import javax.persistence.*;

@Entity
public class ProductOrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    private Integer deleteStatus;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productOrder_id", referencedColumnName = "id")
    private ProductOrder productOrder;

    public ProductOrderDetail() {
    }

    public ProductOrderDetail(Integer id, Integer quantity,
                              Integer deleteStatus, Product product,
                              ProductOrder productOrder) {
        this.id = id;
        this.quantity = quantity;
        this.deleteStatus = deleteStatus;
        this.product = product;
        this.productOrder = productOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }
}
