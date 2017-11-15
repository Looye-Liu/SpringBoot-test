package com.liuyi.action.demo.service;

import com.liuyi.action.demo.entity.Cat;
import com.liuyi.action.demo.repository.CatRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by looye on 2017/11/14.
 */
@Service
public class CatService {

    @Resource
    private CatRepository catRepository;

    @Transactional
    public String insert(Cat cat) {
        catRepository.save(cat);
        return "insert success";
    }

    @Transactional
    public String update(Cat cat) {
        catRepository.save(cat);
        return "update success";
    }

    @Transactional
    public String delete(int id) {
        catRepository.delete(id);
        return "delete success";
    }

    public Cat getById(int id) {
        return catRepository.findOne(id);
    }

    public Iterable<Cat> queryAll() {
        return catRepository.findAll();
    }

}