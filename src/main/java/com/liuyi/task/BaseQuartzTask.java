package com.liuyi.task;


import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by looye on 2017/11/18.
 *
 * @author looye
 * @date 2017/11/18
 */
public class BaseQuartzTask implements Job {

    @Autowired
    private Scheduler scheduler;

    private String className = this.getClass().getSimpleName();

    /**
     * 等同于init-method
     */
    @PostConstruct
    public void init() {
        //创建具体的任务jobDetail
        JobDetail jobDetail = JobBuilder.newJob(this.getClass()).
                withIdentity(String.format("%s_%s", className, "job"), String.format("%s_%s", className, "group")).build();

        //创建触发时间点trigger
        Trigger trigger = buildTrigger();

        //4、将jobDetail和trigger交给scheduler安排触发
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    /**
     * 自定义一个Trigger
     *
     * @return
     */
    protected Trigger buildTrigger() {
        return TriggerBuilder.newTrigger()
                .withIdentity(String.format("%s_%s", className, "trigger"), String.format("%s_%s", className, "tGroup"))
                .withSchedule(CronScheduleBuilder.cronSchedule(getCronExpression()))
                .build();
    }

    /**
     * 获取一个cron表达式
     *
     * @return
     */
    protected String getCronExpression() {
        return "0/5 * * ? * *";
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        excute();
    }

    protected void excute() {
    }
}
