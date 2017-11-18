package com.liuyi.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * spring task在计算时间的时候，是根据当前服务器的系统时间计算
 * 如果是每10秒执行一次的话，那么他会从系统时间的0，10，20秒进行计算的
 * 如果是每分钟执行一次，那么是从1分钟，2分钟进行计算
 * <p>
 * cron表达式 指定： 秒，分，小时，日，月，新期，年（可选）
 * <p>
 * "0 0 12 * * ？" 每天中午十二点触发
 * <p>
 * "0 15 10 * * *" | "0 15 10 ? * *" | "0 15 10 * * ?" | "0 15 10 * ? *"每天早上10：15触发
 * <p>
 * "0 15 10 * * ? 2017"2017年的每天早上10：15触发 spring task只支持6位参数，不支持指定年份
 * <p>
 * "0 * 14 * * *"每天从下午2点开始到2点59每分钟触发一次
 * <p>
 * "0 0/5 14 * * *"每天从下午2点开始到2：55分结束每5分钟一次触发
 * <p>
 * "0 0/5 14,18 * * *"每天的下午2点至2：55结束和6点至6：55两个时段每5分钟触发一次
 * <p>
 * "0 0-5 14 * * *"每天14：00至14：05每分钟一次触发
 * <p>
 * "0 10,44 14 * 3 3"三月的每周三的14：10和14：44触发
 * <p>
 * "0 15 10 * * 1-5"每周一，周二，周三，周四，周五的10：15触发
 * <p>
 * Created by looye on 2017/11/18.
 */
@Configuration
@EnableScheduling
public class TestTask {
    /**
     * 每秒钟一次
     * cron 定时任务指定参数，循环执行时间
     * 指定： 秒，分，小时，日期，月，新期，年（可选）
     */

    @Scheduled(cron = "0/10 * * * * *")
    public void task1() {
        System.out.println("---task1----" + new Date());
    }

    /**
     * 每分钟
     */
    @Scheduled(cron = "0 0/1 * * * *")
    public void task2() {
        System.out.println("---task2----" + new Date());
    }
}
