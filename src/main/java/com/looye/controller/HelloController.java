package com.looye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by looye on 2017/11/17.
 */
@Controller
@RequestMapping("/jsp")
public class HelloController {

    @RequestMapping("/hello")
    public String index(Map<String, Object> map) {
        map.put("name", "looye");
        return "index";
    }
}
