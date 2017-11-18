package com.liuyi.task;

import com.liuyi.job.TestJob2;
import org.quartz.*;
import org.springframework.stereotype.Service;

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
@Service
public class TestTask2 {

    @Resource
    private Scheduler scheduler;

    /**
     * 等同于init-method
     */
    @PostConstruct
    public void init() {
        try {
            scheduler.start();
            System.out.println("----getSchedulerName----" + scheduler.getSchedulerName());
            //创建具体的任务jobDetail
            JobDetail jobDetail = JobBuilder.newJob(TestJob2.class).withIdentity("job2", "group2").build();

            //创建触发时间点trigger
            ScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
                    .startNow().withSchedule(scheduleBuilder).build();

            //4、将jobDetail和trigger交给scheduler安排触发
            scheduler.scheduleJob(jobDetail, trigger);

            //5、睡眠20秒，关闭定时调度任务
            TimeUnit.SECONDS.sleep(20);
            scheduler.shutdown();
            System.out.println("-------stop------" + new Date());
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
