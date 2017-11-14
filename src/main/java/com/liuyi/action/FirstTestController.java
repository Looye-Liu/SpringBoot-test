package com.liuyi.action;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by looye on 2017/11/12.
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
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("liuyi");
        demo.setRemark("aaa");
        demo.setHotMessage("what a girl");
        demo.setCreateTime(new Date());
        return demo;
    }

    @RequestMapping("/getDemo1")
    public Demo getDemo1() {
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("liuyi");
        demo.setRemark("aaa");
        demo.setHotMessage("what a girl");
        demo.setCreateTime(new Date());
        return demo;
    }

}
