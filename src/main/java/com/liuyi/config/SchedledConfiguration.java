package com.liuyi.config;

import com.liuyi.job.TestJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

/**
 * Created by looye on 2017/11/18.
 *
 * @author looye
 * @date 2017/11/18
 */
@Configuration
public class SchedledConfiguration {

    @Bean
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(TestJob job) {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        //设置对应的目标job对象
        bean.setTargetObject(job);
        //设置对应的目标job对象方法
        bean.setTargetMethod("excute");
        return bean;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(MethodInvokingJobDetailFactoryBean jobDetail) {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        //设置对应的目标jobDetail
        bean.setJobDetail(jobDetail.getObject());

        //设置执行表达式
        bean.setCronExpression("0/5 * * * * ?");
        return bean;
    }
}
