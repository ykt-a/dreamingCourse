package com.entiy;

import java.math.BigDecimal;

public class orderItem {
    private Integer id;

    private Integer courseId;

    private Integer orderId;

    private BigDecimal currentUnitPrice;

    private Integer quantity;

    private Integer isAlive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
        this.currentUnitPrice = currentUnitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public String toString() {
        return "YktOrderItem{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", orderId=" + orderId +
                ", currentUnitPrice=" + currentUnitPrice +
                ", quantity=" + quantity +
                ", isAlive=" + isAlive +
                '}';
    }
}
