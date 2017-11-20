package com.looye.task;

import org.quartz.*;
import org.springframework.stereotype.Service;

/**
 * Created by looye on 2017/11/18.
 *
 * @author looye
 * @date 2017/11/18
 */
@Service
public class TestQuartzTask2 extends BaseQuartzTask {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("---- TestQuartzTask2 execute----");
    }

    @Override
    protected Trigger buildTrigger() {
        //创建触发时间点trigger
        ScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
                .startNow().withSchedule(scheduleBuilder).build();
        return trigger;
    }


}
