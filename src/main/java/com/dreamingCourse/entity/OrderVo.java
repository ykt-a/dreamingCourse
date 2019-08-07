package com.dreamingCourse.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by geely
 */
public class OrderVo {
    private Integer userId;

    private Integer payType;

    private Integer status;

    private Integer isAssess;

    private String createTime;

    private Long orderNumber;

    private BigDecimal payment;

    private BigDecimal totalPrice;

    private Date payTime;

    private User user;

    private List<OrderItem> orderItemList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsAssess() {
        return isAssess;
    }

    public void setIsAssess(Integer isAssess) {
        this.isAssess = isAssess;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "userId=" + userId +
                ", payType=" + payType +
                ", status=" + status +
                ", isAssess=" + isAssess +
                ", createTime='" + createTime + '\'' +
                ", orderNumber=" + orderNumber +
                ", payment=" + payment +
                ", totalPrice=" + totalPrice +
                ", payTime=" + payTime +
                ", user=" + user +
                ", orderItemList=" + orderItemList +
                '}';
    }
}
