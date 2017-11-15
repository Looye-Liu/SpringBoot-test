package com.liuyi.action.demo.controller;


import com.liuyi.action.demo.entity.Cat;
import com.liuyi.action.demo.service.CatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by looye on 2017/11/14.
 */
@RestController
@RequestMapping("/cat")
public class CatController {

    @Resource
    private CatService catService;

    @RequestMapping("/insert")
    public String insert() {
        Cat cat = new Cat();
        cat.setCateAge(12);
        cat.setCateName("sam");
        cat.setColour("green");
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
    public ArrayList<Cat> queryAll() {
        ArrayList<Cat> result = new ArrayList<>();
        Iterable<Cat> cats = catService.queryAll();
        for (Cat cat : cats) {
            result.add(cat);
        }
        return result;
    }

    @RequestMapping("/get")
    public Cat getCat(int id) {
        return catService.getById(id);
    }
}
