package com.project.be.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.be.model.order.ProductOrderDetail;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String registerDay;

    private String description;

    private Double price;

    private Integer quantity;

    private Integer deleteStatus;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<ImgUrlProduct> imgUrlProductList;

    @JsonBackReference
    @OneToOne(mappedBy = "product")
    private Guitar guitar;

    @JsonBackReference
    @OneToOne(mappedBy = "product")
    private Piano piano;

    @JsonBackReference
    @OneToMany(mappedBy = "product")
    private Set<ProductOrderDetail> productOrderDetailSet;

    public Product() {
    }

    public Product(Integer id, String name, String registerDay,
                   String description, Double price, Integer quantity,
                   Integer deleteStatus, Brand brand, Category category,
                   List<ImgUrlProduct> imgUrlProductList, Guitar guitar,
                   Piano piano, Set<ProductOrderDetail> productOrderDetailSet) {
        this.id = id;
        this.name = name;
        this.registerDay = registerDay;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.deleteStatus = deleteStatus;
        this.brand = brand;
        this.category = category;
        this.imgUrlProductList = imgUrlProductList;
        this.guitar = guitar;
        this.piano = piano;
        this.productOrderDetailSet = productOrderDetailSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterDay() {
        return registerDay;
    }

    public void setRegisterDay(String registerDay) {
        this.registerDay = registerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ImgUrlProduct> getImgUrlProductList() {
        return imgUrlProductList;
    }

    public void setImgUrlProductList(List<ImgUrlProduct> imgUrlProductList) {
        this.imgUrlProductList = imgUrlProductList;
    }

    public Guitar getGuitar() {
        return guitar;
    }

    public void setGuitar(Guitar guitar) {
        this.guitar = guitar;
    }

    public Piano getPiano() {
        return piano;
    }

    public void setPiano(Piano piano) {
        this.piano = piano;
    }

    public Set<ProductOrderDetail> getProductOrderDetailSet() {
        return productOrderDetailSet;
    }

    public void setProductOrderDetailSet(Set<ProductOrderDetail> productOrderDetailSet) {
        this.productOrderDetailSet = productOrderDetailSet;
    }

}
