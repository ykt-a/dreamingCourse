package com.entiy;

import java.math.BigDecimal;
import java.util.Date;

public class course {
    private Integer id;
    private Integer tagId;
    private String name;
    private String subtitle;
    private String mainImage;
    private Long activityPrice;
    private BigDecimal price;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private Integer isAlive;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getTagId() {
        return tagId;
    }
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public String getSubtitle() {
        return subtitle;
    }
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }
    public String getMainImage() {
        return mainImage;
    }
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
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
    @Override
    public String toString() {
        return "YktCourse{" +
                "id=" + id +
                ", tagId=" + tagId +
                ", name='" + name + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", activityPrice=" + activityPrice +
                ", price=" + price +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", isAlive=" + isAlive +
                '}';
    }
}
