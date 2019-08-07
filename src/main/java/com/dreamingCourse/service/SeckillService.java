package com.dreamingCourse.service;

import com.dreamingCourse.entity.SeckillGoods;

import java.util.List;

/**
 * @author zth
 * @Date 2019-08-05 11:07
 */

public interface SeckillService {

    // 根据时间段获取当天秒杀商品
    public List<SeckillGoods> getTodayGoodsByTime(int time);

    // 添加秒杀商品到缓存
    public void addSecKillGoodsInRedis(SeckillGoods seckillGoods);

    // 添加当天的秒杀商品到缓存
    public void addThisTimeGoodsToRedis(int time);

    // 添加当天的秒杀商品到缓存
    public void addTodayGoodsToRedis();

    // 删除昨天缓存中的秒杀商品
    public void delYestodayGoodsFromRedis();

    // 查看当前秒杀商品的库存
    public int getStockByGID(int GID,int time);

    // 库存减一
    public void decreaseNum(int GID,int time);

    // 判断该用户是否已经购买过此商品
    public boolean isBought(int UID,int time);

    // 删除昨天记录每个时间段已秒杀的用户的set
    public void delUserSet();

    // 添加当前用户到已秒杀用户set
    public void addUserToSet(int UID,int time);





}
