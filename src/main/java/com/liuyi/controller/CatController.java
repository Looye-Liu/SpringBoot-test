package com.liuyi.controller;

import com.liuyi.entity.Cat;
import com.liuyi.service.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by looye on 2017/11/14.
 */
@Controller
@RequestMapping("/cat")
public class CatController {

    @Resource
    private CatService catService;

    @RequestMapping("/insert")
    public String insert() {
        Cat cat = new Cat();
        cat.setCateAge(12);
        cat.setCateName("tom");
        cat.setColour("blue");
        return catService.insert(cat);
    }

    @RequestMapping("/update")
    public String update() {
        Cat cat = new Cat();
        cat.setId(1);
        cat.setCateAge(12);
        cat.setCateName("tom");
        cat.setColour("blue");
        return catService.update(cat);
    }

    @RequestMapping("/delete")
    public String delete(int id) {
        return catService.delete(id);
    }

    @RequestMapping("/queryAll")
    public Iterable<Cat> queryAll() {
        return catService.queryAll();
    }
}
