package com.dreamingCourse.service.impl;

import com.dreamingCourse.entity.SeckillGoods;
import com.dreamingCourse.mapper.SeckillGoodsMapper;
import com.dreamingCourse.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zth
 * @Date 2019-08-05 11:10
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    SeckillGoodsMapper seckillGoodsMapper;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 获取当天指定时间段的秒杀商品
     * @param time
     * @return
     */
    @Override
    public List<SeckillGoods> getTodayGoodsByTime(int time) {
        return seckillGoodsMapper.getTodayGoodsByTime(time);
    }

    /**
     * 将指定商品加入缓存
     */
    @Override
    public void addSecKillGoodsInRedis(SeckillGoods seckillGoods) {
        Map<String, Object> goodsMap = new HashMap();

        goodsMap.put("id", seckillGoods.getId());
        goodsMap.put("name", seckillGoods.getName());
        goodsMap.put("price", seckillGoods.getPrice());
        goodsMap.put("originPrice", seckillGoods.getOriginPrice());
        goodsMap.put("pic", seckillGoods.getPic());
        goodsMap.put("number", seckillGoods.getNumber());
        goodsMap.put("startTime", seckillGoods.getStartTime());
        goodsMap.put("createTime", seckillGoods.getCreateTime());
        goodsMap.put("isAlive", seckillGoods.getIsAlive());
        goodsMap.put("desc", seckillGoods.getDesc());
        goodsMap.put("startDay", seckillGoods.getStartDay());
        goodsMap.put("cid", seckillGoods.getStartDay());

        redisTemplate.setKeySerializer(new StringRedisSerializer());

        HashOperations hashOperations = redisTemplate.opsForHash();
        String key = "goods_" + Calendar.getInstance().getTime().getDate() + "_" + seckillGoods.getStartTime() + "_" + seckillGoods.getId();
        System.out.println(key);
        hashOperations.putAll(key, goodsMap);

    }

    /**
     * 添加当前时间段的商品到缓存
     * @param time
     */
    @Override
    public void addThisTimeGoodsToRedis(int time) {
        List<SeckillGoods> list = getTodayGoodsByTime(time);
        //加入缓存
        if (null != list && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                addSecKillGoodsInRedis(list.get(i));
            }
        }

    }

    /**
     * 将当天的商品添加到缓存
     */
    @Override
    public void addTodayGoodsToRedis() {
        addThisTimeGoodsToRedis(10);
        addThisTimeGoodsToRedis(16);
        addThisTimeGoodsToRedis(20);
        System.out.println("添加缓存完成");
    }

    /**
     * 将昨天的商品从缓存中删除
     */
    @Override
    public void delYestodayGoodsFromRedis() {
        // 获取待删除的 key 值
        String key = "goods_" + (Calendar.getInstance().getTime().getDate() - 1) + "*";
        System.out.println(key);
        Set keys = redisTemplate.keys(key);
        System.out.println(keys.toString());
        redisTemplate.delete(keys);
    }

    /**
     * 查看库存数量
     */
    @Override
    public int getStockByGID(int GID, int time) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        String key = "goods_" + Calendar.getInstance().getTime().getDate() + "_" + time + "_" + GID;
        int num = (Integer) redisTemplate.opsForHash().get(key, "number");
        return num;
    }


    /**
     * 库存减一
     */

    @Override
    public void decreaseNum(int GID, int time) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        String key = "goods_" + Calendar.getInstance().getTime().getDate() + "_" + time + "_" + GID;

        System.out.println("######" + key);

        int num = (Integer) redisTemplate.opsForHash().get(key, "number");
        redisTemplate.opsForHash().put(key, "number", num - 1);
    }

    @Override
    public boolean isBought(int UID, int time) {
        String key = "User_" + Calendar.getInstance().getTime().getDate() + "_" + time;
        //redisTemplate.setValueSerializer(new StringRedisSerializer());
        SetOperations setOperations = redisTemplate.opsForSet();
        boolean res = setOperations.isMember(key, UID);
        if (res == false) {
            setOperations.add(key, UID);
        }
        return res;
    }

    @Override
    public void delUserSet() {
        // 获取待删除的 key 值
        String key = "User_" + (Calendar.getInstance().getTime().getDate() - 1) + "*";
        //String key = "goods_"+ (Calendar.getInstance().getTime().getDate()-1) + "*";
        System.out.println(key);
        Set keys = redisTemplate.keys(key);
        System.out.println(keys.toString());
        redisTemplate.delete(keys);
    }

    @Override
    public void addUserToSet(int UID, int time) {
        String key = "User_" + Calendar.getInstance().getTime().getDate() + "_" + time;
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add(key, UID);
    }

    @Override
    public SeckillGoods deleteByPrimaryKey(Long id) {
        return seckillGoodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SeckillGoods insert(SeckillGoods record) {
        return seckillGoodsMapper.insert(record);
    }

    @Override
    public SeckillGoods selectByPrimaryKey(Long id) {
        return seckillGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SeckillGoods> selectAll() {
        return seckillGoodsMapper.selectAll();
    }

    @Override
    public SeckillGoods updateByPrimaryKey(SeckillGoods record) {
        return seckillGoodsMapper.updateByPrimaryKey(record);
    }
}
