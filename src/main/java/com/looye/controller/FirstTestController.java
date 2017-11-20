package com.looye.controller;

import com.looye.Demo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by looye on 2017/11/12.
 * 注解@RestController 等价与@Controller(加在类上) 加上 @ResponseBody(加在方法上)
 */
@RestController
public class FirstTestController {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/hello/{myName}")
    String index(@PathVariable String myName) {
        return "Hello " + myName + "!!!";
    }

    /**
     * Spring Boot 默认使用的json解析框架是jackson
     *
     * @return
     */
    @RequestMapping("/getDemo")
    public Demo getDemo() {
        return buildDemo("demo");
    }

    @RequestMapping("/getDemo1")
    public Demo getDemo1() {
        return buildDemo("demo1");
    }

    @RequestMapping("/getDemo2")
    public Demo getDemo2() {
        return buildDemo("demo2");
    }

    private Demo buildDemo(String name) {
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName(name);
        demo.setRemark("aaa");
        demo.setHotMessage("what a girl");
        demo.setCreateTime(new Date());
        return demo;
    }

}
