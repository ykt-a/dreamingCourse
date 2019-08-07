package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.SeckillGoods;

import java.math.BigDecimal;
import java.util.List;

public interface SeckillGoodsMapper {

    // 返回当天秒杀的所有商品
    List<SeckillGoods> getTodayGoodsByTime(int time);

    // 数据库中减库存
    public void decreaseNum(int GID);

    // 通过秒杀商品ID 查询商品ID
    public int getCourseID(int GID);

    // 通过秒杀商品ID 查询商品ID
    public BigDecimal getCoursePrice(int GID);

}