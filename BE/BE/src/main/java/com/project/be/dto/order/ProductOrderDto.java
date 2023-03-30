package com.project.be.dto.order;

public class ProductOrderDto {

    private Integer id;

    private String orderDate;

    private Integer deleteStatus;

    private Integer paymentStatus;

    private Long totalMoney;

    private Integer userId;

    public ProductOrderDto(Integer id, String orderDate,
                           Integer deleteStatus, Integer paymentStatus,
                           Long totalMoney, Integer userId) {
        this.id = id;
        this.orderDate = orderDate;
        this.deleteStatus = deleteStatus;
        this.paymentStatus = paymentStatus;
        this.totalMoney = totalMoney;
        this.userId = userId;
    }

    public ProductOrderDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
