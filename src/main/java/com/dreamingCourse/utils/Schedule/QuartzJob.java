package com.dreamingCourse.utils.Schedule;

import com.dreamingCourse.entity.Order;
import com.dreamingCourse.mapper.OrderMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class QuartzJob implements Job {
    @Autowired
    private OrderMapper orderMapper;
    //失效订单编号
    int id;
    //订单创建时间大于20分钟，就失效
    public static final long EFFTIVE_TIME = 20*60*1000;
    private static Log log = LogFactory.getLog(QuartzJob.class);


    //执行取消失效订单
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
         findFailureOrder();
    }
/**
     * 查找失效订单
     * @return
     */
    public int findFailureOrder(){
        int id=-1;
        //定义当前时间
        long now;
        //查询创建时间
        long before;
        //时间差
        long diff=0;
        //当前时间获得
        Date time=new Date();

       // log.info("失效订单检测任务开始执行。。。。。");

        // 在每次启动Job时去数据库查找订单创建时间，获取当前时间，判断其是否失效
       List<Order> orders = this.orderMapper.findAllOrder();
            for(Order order:orders){
                 now=time.getTime();
                 before=order.getCreateTime().getTime();
                //时间差
                 diff=now-before;
                if(diff>=EFFTIVE_TIME){
                    if(order.getStatus().equals(0)){
                        this.orderMapper.closeFailureOrders(order.getOrderNumber());
                        log.info("订单编号为"+order.getOrderNumber()+"失效");
                    }
                }else{
                    log.info("订单编号为："+order.getOrderNumber()+"订单创建时间为："+order.getCreateTime()+
                           "当前时间为："+time+"还剩"+(EFFTIVE_TIME-diff)/(1000*60)+"分钟交易关闭");
                }
        }
        return id;
        }
}
