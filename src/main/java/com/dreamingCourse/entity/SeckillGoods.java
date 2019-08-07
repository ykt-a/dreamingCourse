package com.dreamingCourse.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SeckillGoods implements Serializable {
    private Long id;

    private String name;

    private BigDecimal price;

    private BigDecimal originPrice;

    private String pic;

    private Integer number;

    private Integer startTime;

    private Date createTime;

    private Integer isAlive;

    private String desc;

    private Date startDay;

    private Long cid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(BigDecimal originPrice) {
        this.originPrice = originPrice;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "SeckillGoods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", originPrice=" + originPrice +
                ", pic='" + pic + '\'' +
                ", number=" + number +
                ", startTime=" + startTime +
                ", createTime=" + createTime +
                ", isAlive=" + isAlive +
                ", desc='" + desc + '\'' +
                ", startDay=" + startDay +
                ", cid=" + cid +
                '}';
    }
}