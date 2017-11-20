package com.looye.task;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by looye on 2017/11/18.
 *
 * @author looye
 * @date 2017/11/18
 */
@EnableScheduling
@RequestMapping("/task")
@RestController
public class DynamicTask {

    private Runnable dynamicTask = new Runnable() {
        @Override
        public void run() {
            System.out.println("----dynamicTask----" + new Date());
        }
    };

    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @RequestMapping("/start")
    public String startCron() {
        future = threadPoolTaskScheduler.schedule(dynamicTask, new CronTrigger("0/5 * * * * *"));
        return "启动成功";
    }

    @RequestMapping("/stop")
    public String stopCron() {
        if (future != null) {
            future.cancel(true);
        }
        return "关闭成功";
    }

    @RequestMapping("/restart")
    public String restart() {
        stopCron();// 先停止，在开启.
        future = threadPoolTaskScheduler.schedule(dynamicTask, new CronTrigger("*/10 * * * * *"));
        return "重启成功";
    }


}
