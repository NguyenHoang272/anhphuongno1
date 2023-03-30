package com.project.be.payload.request;

public class ProductSearchInfo {

    private String productName;
    private String categoryId;
    private String brandId;
    private String priceRange;
    private String pageNumber;
    private String pageSize;
    private String sortByPrice;
    public ProductSearchInfo() {
    }

    public ProductSearchInfo(String productName, String categoryId, String brandId,
                             String priceRange, String pageNumber, String pageSize,
                             String sortByPrice) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.priceRange = priceRange;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortByPrice = sortByPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortByPrice() {
        return sortByPrice;
    }

    public void setSortByPrice(String sortByPrice) {
        this.sortByPrice = sortByPrice;
    }

}
