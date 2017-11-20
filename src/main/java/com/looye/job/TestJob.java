package com.looye.job;

import org.springframework.stereotype.Component;

/**
 * Created by looye on 2017/11/18.
 *
 * @author looye
 * @date 2017/11/18
 */
@Component
public class TestJob {
    public void excute() {
        System.out.println("---TestJob-ScheduleTask excute----");
    }
}
