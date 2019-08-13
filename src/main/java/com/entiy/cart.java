package com.entiy;

import java.math.BigDecimal;
import java.util.Date;

public class cart {
    private Integer        id;
    private Integer        userId;
    private Integer        courseId;
    private Integer        quantity;
    private Long           activityPrice;
    private BigDecimal price;
    private BigDecimal     total;
    private Date createTime;
    private Integer        status;
    private Integer        isAlive;
    private Integer        submissionStatus;
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
    public Long getActivityPrice() {
        return activityPrice;
    }
    public void setActivityPrice(Long activityPrice) {
        this.activityPrice = activityPrice;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
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
    public Integer getSubmissionStatus() {
        return submissionStatus;
    }
    public void setSubmissionStatus(Integer submissionStatus) {
        this.submissionStatus = submissionStatus;
    }
    @Override
    public String toString() {
        return "YktCart{" +
                "id=" + id +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", quantity=" + quantity +
                ", activityPrice=" + activityPrice +
                ", price=" + price +
                ", total=" + total +
                ", createTime=" + createTime +
                ", status=" + status +
                ", isAlive=" + isAlive +
                ", submissionStatus=" + submissionStatus +
                '}';
    }
}
