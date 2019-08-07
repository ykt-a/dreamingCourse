package com.dreamingCourse.utils.Schedule;

import com.dreamingCourse.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zth
 * @Date 2019-08-05 12:30
 */

@Component
public class TimingToRedis {
    @Autowired
    SeckillService seckillService;
    /**
     * 每天凌晨十二点触发
     * 将当天的秒杀商品加入缓存
     * 将昨天的秒杀商品从缓存中删除
     *
     */
    @Scheduled(cron="0 0 0 * * *")
    public void addTodayGoodsInRedsi(){
        System.out.println("触发器11111被触发"+new Date());
        seckillService.addTodayGoodsToRedis();
        seckillService.delYestodayGoodsFromRedis();
        seckillService.delUserSet();

    }

   /* //@Scheduled(cron="0 0 1 * * *") //每天凌晨 1 点执行一次
    @Scheduled(cron = "0/2 * * * * *")
    public void Scheduled(){
        System.out.println("触发器2222被触发"+new Date());
    }*/
}
