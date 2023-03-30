package com.project.be.payload.request;

public class TotalMoney {

    private Long totalMoney;
    private Integer orderId;

    public TotalMoney() {
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
