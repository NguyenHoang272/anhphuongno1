package com.project.be.dto.product;

import com.project.be.model.product.*;

import java.util.Set;

public class ProductDto {

    private Integer id;

    private String registerDay;

    private String description;

    private Double price;

    private Integer quantity;

    private Integer deleteStatus;

    private Brand brand;

    private Category category;

    private Set<ImgUrlProduct> imgUrlProductSet;

    private Guitar guitar;

    private Piano piano;

    public ProductDto() {
    }

    public ProductDto(Integer id, String registerDay, String description,
                      Double price, Integer quantity, Integer deleteStatus,
                      Brand brand, Category category, Set<ImgUrlProduct> imgUrlProductSet,
                      Guitar guitar, Piano piano) {
        this.id = id;
        this.registerDay = registerDay;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.deleteStatus = deleteStatus;
        this.brand = brand;
        this.category = category;
        this.imgUrlProductSet = imgUrlProductSet;
        this.guitar = guitar;
        this.piano = piano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<ImgUrlProduct> getImgUrlProductSet() {
        return imgUrlProductSet;
    }

    public void setImgUrlProductSet(Set<ImgUrlProduct> imgUrlProductSet) {
        this.imgUrlProductSet = imgUrlProductSet;
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
}
