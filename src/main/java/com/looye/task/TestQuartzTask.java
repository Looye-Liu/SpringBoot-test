package com.looye.task;

import com.looye.service.TaskService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by looye on 2017/11/18.
 *
 * @author looye
 * @date 2017/11/18
 */
@Service
public class TestQuartzTask extends BaseQuartzTask {

    /**
     * Quartz中的job是有Quartz框架 动态创建的，通过配置该job的className,反射动态创建
     * 所有在job使用spring bean 的话，是无法进行使用的。job类不是一个spring bean
     *
     * 使用AutowireCapableBeanFachtory进行自动注入job
     *
     */
    @Resource
    private TaskService service;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("---- TestQuartzTask execute----");
        service.printHello();
    }

    @Override
    protected String getCronExpression() {
        return "0/10 * * ? * *";
    }
}
