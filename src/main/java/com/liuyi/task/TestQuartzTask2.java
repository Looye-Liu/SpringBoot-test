package com.liuyi.task;

import com.liuyi.job.TestQuartzJob2;
import org.quartz.ScheduleBuilder;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by looye on 2017/11/18.
 *
 * @author looye
 * @date 2017/11/18
 */
@Service
public class TestQuartzTask2 extends BaseQuartzTask {
    TestQuartzTask2() {
        super("job2", "group2", "0/10 * * * * *", TestQuartzJob2.class);
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
