package com.dreamingCourse.controller;

import com.dreamingCourse.service.SeckillService;
import com.dreamingCourse.utils.ActiveMQ.ActiveMQSender;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zth
 * @Date 2019-08-04 17:26
 */
@RequestMapping("/secKill")
@Controller
public class SecKill {

    @Autowired
    ActiveMQSender activeMQSender;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    SeckillService seckillService;


    @RequestMapping("/buy")
    @ResponseBody
    @Transactional
    public String secKill(int time ,int UID, int GID){

        // 获取当前系统时间
        int hour = Calendar.getInstance().getTime().getHours();
        if (hour<time){
            return "未开始";
        }
        if (hour > time){
            return "秒杀结束";
        }

        // 查看秒杀商品的库存
        int num = seckillService.getStockByGID(GID,time);

        boolean isBought = seckillService.isBought(UID,time);

        if (isBought){
            return "您已秒杀";
        }
        if (num>0){
            Destination destination=new ActiveMQQueue("seckill.queue");
            activeMQSender.sendChannelMess(destination,GID+"_"+UID);
        }else {
            return "已抢完";
        }

        return "秒杀成功";
    }

    @RequestMapping("/getTime")
    @ResponseBody
    public String getTime(){
        return new Date().toString();
    }


    @RequestMapping("/getNum")
    @ResponseBody
    public Integer getGoodsInredis(String key){
        HashOperations hashOperations = redisTemplate.opsForHash();
        return (Integer)hashOperations.get(key,"number");
    }

}
