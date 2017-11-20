package com.looye.task;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by looye on 2017/11/18.
 *
 * @author looye
 * @date 2017/11/18
 */
@EnableScheduling
@RequestMapping("/task")
@RestController
public class CronChangeTask implements SchedulingConfigurer {

    private String expression = "0/5 * * * * *";

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("----configureTask----" + new Date());
            }
        };
        Trigger trigger = new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger cronTrigger = new CronTrigger(expression);
                return cronTrigger.nextExecutionTime(triggerContext);
            }
        };
        scheduledTaskRegistrar.addTriggerTask(runnable, trigger);
    }

    @RequestMapping("/changeExpression")
    public String changeExpression() {
        String expression = "0/10 * * * * *";
        this.expression = expression;
        return "修改成功ß";
    }
}
