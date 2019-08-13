package com.dreamingCourse.utils.redis;

import com.dreamingCourse.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author zth
 * @Date 2019-08-05 19:03
 */
@Component
public class RunOnceAtStart implements ApplicationRunner {
    @Autowired
    SeckillService seckillService;
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("启动执行。。。。");
       seckillService.addTodayGoodsToRedis();
    }
}
