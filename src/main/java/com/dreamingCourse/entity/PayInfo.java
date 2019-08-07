package com.dreamingCourse.entity;

import java.util.Date;

public class PayInfo {

    private Integer id;

    private Long orderNumber;

    private Integer payPlatform;

    private String platformNumber;

    private String payStatus;

    private Date createTime;

    private Date updateTime;

    private Integer isAlive;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }


    public Integer getPayPlatform() {
        return payPlatform;
    }


    public void setPayPlatform(Integer payPlatform) {
        this.payPlatform = payPlatform;
    }


    public String getPlatformNumber() {
        return platformNumber;
    }


    public void setPlatformNumber(String platformNumber) {
        this.platformNumber = platformNumber == null ? null : platformNumber.trim();
    }


    public String getPayStatus() {
        return payStatus;
    }


    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
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
}