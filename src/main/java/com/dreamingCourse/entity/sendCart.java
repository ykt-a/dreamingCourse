package com.dreamingCourse.entity;

import java.math.BigDecimal;

public class sendCart {
    private Integer       id;
    private Integer       userId;
    private String        image;
    private String        userName;
    private Integer       role;
    public  String        courseImage;
    private Integer       courseId;
    private String        courseName;
    private Integer       quantity;
    private Long          activityPrice;
    private BigDecimal    price;
    private String        data;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public String getUserImage() {
        return image;
    }

    public void setUserImage(String userImage) {
        this.image = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    @Override
    public String toString() {
        return "sendcart{" +
                "id=" + id +
                ", userId=" + userId +
                ", image='" + image + '\'' +
                ", userName='" + userName + '\'' +
                ", role=" + role +
                ", courseImage='" + courseImage + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", quantity=" + quantity +
                ", activityPrice=" + activityPrice +
                ", price=" + price +
                ", data='" + data + '\'' +
                '}';
    }
}
