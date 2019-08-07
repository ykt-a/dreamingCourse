package com.dreamingCourse.entity;

import java.math.BigDecimal;

public class OrderItem {
    private Integer id;

    private Integer courseId;

    private Long orderNumber;

    private BigDecimal currentUnitPrice;

    private Integer quantity;

    private Integer isAlive;

    private Integer userId;

    private String courseName;



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

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", orderNumber=" + orderNumber +
                ", currentUnitPrice=" + currentUnitPrice +
                ", quantity=" + quantity +
                ", isAlive=" + isAlive +
                ", userId=" + userId +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}