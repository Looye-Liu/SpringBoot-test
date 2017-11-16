package com.liuyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 在Thymeleaf模版文件中，标签是需要闭合的，3。0之前是必须的，
 * 在3。0之后可以不强制闭合
 * Created by looye on 2017/11/16.
 */
@Controller
@RequestMapping("/templates")
public class TemplateController {

    @RequestMapping("/hello")
    public String hello(Map<String, Object> map) {
        map.put("name", "looye");
        return "hello";
    }

    @RequestMapping("/hello2")
    public ModelAndView hello2() {
        //正常情况返回的ModelAndView
        ModelAndView mv = new ModelAndView("hello");
        return mv;
    }
}
