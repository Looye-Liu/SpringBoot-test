package com.liuyi.service;

import com.liuyi.dao.CatDao;
import com.liuyi.entity.Cat;
import com.liuyi.repository.CatRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by looye on 2017/11/14.
 */
@Service
public class CatService {

    @Resource
    private CatRepository catRepository;

    @Resource
    private CatDao catDao;

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

    public Cat getCatDao(String catName) {
        return catDao.selectByCatName(catName);
    }

    public Cat getCatDaoName(String colour) {
        return catDao.selectByCatColour(colour);
    }

    public List<Cat> getCatListDao(String colour) {
        return catDao.selectByCatColour2(colour);
    }

}