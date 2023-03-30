package com.project.be.dto.product;

import com.project.be.model.product.*;

import java.util.Set;

public class ProductHomeShow {

    private Integer id;

    private String name;

    private Double price;

    private String brand;

    private String category;

    private String homeImgCart;

    public ProductHomeShow() {
    }

    public ProductHomeShow(Integer id, String name,
                           Double price, String brand,
                           String category, String homeImgCart) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.homeImgCart = homeImgCart;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHomeImgCart() {
        return homeImgCart;
    }

    public void setHomeImgCart(String homeImgCart) {
        this.homeImgCart = homeImgCart;
    }
}
