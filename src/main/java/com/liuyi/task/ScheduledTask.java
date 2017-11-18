package com.liuyi.task;

import org.springframework.stereotype.Component;

/**
 * Created by looye on 2017/11/18.
 *
 * @author looye
 * @date 2017/11/18
 */
@Component
public class ScheduledTask {

    public void excute() {
        System.out.println("----ScheduleTask excute----");
    }
}
