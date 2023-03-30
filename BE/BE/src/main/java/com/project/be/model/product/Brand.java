package com.project.be.model.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String originPlace;

    private String brandImgUrl;

    private String deleteStatus;

    @JsonManagedReference
    @OneToMany(mappedBy = "brand")
    private Set<Product> productSet;

    public Brand() {
    }

    public Brand(Integer id, String name, String originPlace, String brandImgUrl, String deleteStatus) {
        this.id = id;
        this.name = name;
        this.originPlace = originPlace;
        this.brandImgUrl = brandImgUrl;
        this.deleteStatus = deleteStatus;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
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

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public String getBrandImgUrl() {
        return brandImgUrl;
    }

    public void setBrandImgUrl(String brandImgUrl) {
        this.brandImgUrl = brandImgUrl;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
