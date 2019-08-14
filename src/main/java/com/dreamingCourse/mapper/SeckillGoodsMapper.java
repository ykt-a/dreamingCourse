package com.dreamingCourse.mapper;

import com.dreamingCourse.entity.SeckillGoods;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface SeckillGoodsMapper {

    // 返回当天秒杀的所有商品
    List<SeckillGoods> getTodayGoodsByTime(int time);

    // 数据库中减库存
    public void decreaseNum(int GID);

    // 通过秒杀商品ID 查询商品ID
    public int getCourseID(int GID);

    // 通过秒杀商品ID 查询商品ID
    public BigDecimal getCoursePrice(int GID);

    SeckillGoods deleteByPrimaryKey(Long id);

    SeckillGoods insert(SeckillGoods record);

    SeckillGoods selectByPrimaryKey(Long id);

    List<SeckillGoods> selectAll();

    SeckillGoods updateByPrimaryKey(SeckillGoods record);

}