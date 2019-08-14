package com.dreamingCourse.utils.ActiveMQ;

import com.dreamingCourse.mapper.SeckillGoodsMapper;
import com.dreamingCourse.service.OrderService;
import com.dreamingCourse.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zth
 * @Date 2019-08-04 17:08
 * 消费者
 */
@Service
public class ActiveMQConsumer {

    @Autowired
    OrderService orderService;

    @Autowired
    SeckillService seckillService;

    @Autowired
    SeckillGoodsMapper seckillGoodsMapper;

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "seckill.queue")
    public void receiveQueue(String message) {


        int goodsID = Integer.valueOf(message.substring(0,message.lastIndexOf('_')));
        int userID = Integer.valueOf(message.substring(message.lastIndexOf('_')+1));

        // 下单
        orderService.createOrderSecKill(userID,goodsID);

        // 缓存中减库存  public void decreaseNum(int GID,int time);
        int nowTime = new Date().getHours();
        int time = 0;
        if (nowTime<15){
            time = 10;
        }else if(nowTime<19){
            time = 16;
        }else {
            time = 20;
        }
        seckillService.decreaseNum(goodsID,time);

        // 数据库中减库存
        seckillGoodsMapper.decreaseNum(goodsID);

    }
}
