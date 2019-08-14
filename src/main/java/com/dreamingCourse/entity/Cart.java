package com.dreamingCourse.entity;


import java.math.BigDecimal;
import java.util.Date;

public class Cart {
    private Integer id;

    private Integer userId;

    private Integer courseId;

    private Integer quantity;

    private Date createTime;

    private Integer status;

    private Integer isAlive;

    private BigDecimal price;

    private Integer submissionStatus;

    private Long activityPrice;

    private BigDecimal total;


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


    public Integer getCourseId() {
        return courseId;
    }


    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }


    public Integer getQuantity() {
        return quantity;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getIsAlive() {
        return isAlive;
    }


    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSubmissionStatus() {
        return submissionStatus;
    }

    public void setSubmissionStatus(Integer submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    public Long getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(Long activityPrice) {
        this.activityPrice = activityPrice;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", quantity=" + quantity +
                ", createTime=" + createTime +
                ", status=" + status +
                ", isAlive=" + isAlive +
                ", price=" + price +
                ", submissionStatus=" + submissionStatus +
                ", activityPrice=" + activityPrice +
                ", total=" + total +
                '}';
    }

}