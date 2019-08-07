package com.dreamingCourse.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {

    private Integer id;

    private Integer userId;

    private BigDecimal payment;

    private BigDecimal totalPrice;

    private Integer payType;

    private Integer status;

    private Integer isAssess;

    private Date payTime;

    private Date sendTime;

    private Date endTime;

    private Date closeTime;

    private Date createTime;

    private Date updateTime;

    private Integer isAlive;
    private Integer isKill;

    private Long orderNumber;

    public Integer getIsKill() {
        return isKill;
    }

    public void setIsKill(Integer isKill) {
        this.isKill = isKill;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public BigDecimal getPayment() {
        return payment;
    }


    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }


    public Integer getPayType() {
        return payType;
    }


    public void setPayType(Integer payType) {
        this.payType = payType;
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


    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }


    public Date getSendTime() {
        return sendTime;
    }


    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }


    public Date getEndTime() {
        return endTime;
    }


    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public Date getCloseTime() {
        return closeTime;
    }


    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public Integer getIsAlive() {
        return isAlive;
    }


    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;

    }
}