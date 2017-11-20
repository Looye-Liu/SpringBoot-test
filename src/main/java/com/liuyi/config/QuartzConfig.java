package com.liuyi.config;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by looye on 2017/11/18.
 * <p>
 * quartz的配置类
 * 1、SchedulerFactoryBean
 * 2、Scheduler类
 *
 * @author looye
 * @date 2017/11/18
 */
@Configuration
public class QuartzConfig {

    @Autowired
    private SpringBeanJobFactory springBeanJobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(springBeanJobFactory);
        return schedulerFactoryBean;
    }

    @Bean
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }

}
