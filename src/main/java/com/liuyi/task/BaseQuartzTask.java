package com.liuyi.task;


import org.quartz.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by looye on 2017/11/18.
 *
 * @author looye
 * @date 2017/11/18
 */
public class BaseQuartzTask {

    @Resource
    private Scheduler scheduler;

    private String jobName;

    private String groupName;

    private String cronExpression;

    private Class<? extends Job> jobClass;

    BaseQuartzTask(String jobName, String groupName, String cronExpression, Class<? extends Job> jobClass) {
        this.jobName = jobName;
        this.groupName = groupName;
        this.jobClass = jobClass;
        this.cronExpression = cronExpression;
    }

    /**
     * 等同于init-method
     */
    @PostConstruct
    public void init() {
        try {
            scheduler.start();
            System.out.println("----getSchedulerName----" + scheduler.getSchedulerName());
            //创建具体的任务jobDetail
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, groupName).build();

            //创建触发时间点trigger
            Trigger trigger = buildTrigger();

            //4、将jobDetail和trigger交给scheduler安排触发
            scheduler.scheduleJob(jobDetail, trigger);

            //5、睡眠20秒，关闭定时调度任务
            TimeUnit.SECONDS.sleep(20);
            scheduler.pauseJob(jobDetail.getKey()); //暂停
            //scheduler.shutdown();
            System.out.println("-------stop------" + new Date());
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
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
                .withIdentity(jobName, groupName)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
    }

}
