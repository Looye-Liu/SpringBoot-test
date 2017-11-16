package com.liuyi.controller;


import com.liuyi.entity.Cat;
import com.liuyi.service.CatService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by looye on 2017/11/14.
 */
@RestController
@RequestMapping("/cat")
public class CatController {

    @Resource
    private CatService catService;

    @RequestMapping("/insert")
    public String insert(String catName) {
        String name = StringUtils.isEmpty(catName) ? UUID.randomUUID().toString().substring(0, 5) : catName;
        Cat cat = new Cat();
        int age = new Random().nextInt(10);
        String colour;
        if (age > 3) {
            colour = "red";
        } else if (age > 6) {
            colour = "blue";
        } else {
            colour = "green";
        }
        cat.setCatAge(age);
        cat.setCatName(name);
        cat.setColour(colour);
        return catService.insert(cat);
    }

    @RequestMapping("/update")
    public String update() {
        Cat cat = new Cat();
        cat.setId(1);
        cat.setCatAge(12);
        cat.setCatName("tom");
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

    @RequestMapping("/dao/get")
    public Cat getCatDao(String catName) {
        return catService.getCatDao(catName);
    }

    @RequestMapping("/dao/getByColour")
    public Cat getCatDao1(String colour) {
        return catService.getCatDaoName(colour);
    }

    @RequestMapping("/dao/getByColour2")
    public List<Cat> getCatDao2(String colour) {
        return catService.getCatListDao(colour);
    }

}
