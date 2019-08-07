package com.dreamingCourse.utils.Schedule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfig {
/**
     * 1.创建Job对象
     */

    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        //关联我们自己的Job类
        factory.setJobClass(QuartzJob.class);
        return factory;
    }


/**
     * 2.创建Trigger对象
     * 简单的Trigger
     */

	@Bean
	public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
		SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
		//用户点击了查询所有订单后，才进行查询失效订单
            //关联JobDetail对象
            factory.setJobDetail(jobDetailFactoryBean.getObject());
		//未设置任务重复时间，每1ms执行一次查询失效订单，并更新订单状态
	   	factory.setRepeatInterval(60*1*1000);
		return factory;
	}
/**
     * 3.创建Scheduler对象
     */

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean, MyAdaptableJobFactory myAdaptableJobFactory ){
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        //关联trigger
        factory.setTriggers(simpleTriggerFactoryBean.getObject());
        factory.setJobFactory(myAdaptableJobFactory);
        return factory;
    }
}

