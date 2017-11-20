package com.looye.service;

import com.looye.dao.CatDao;
import com.looye.entity.Cat;
import com.looye.mapper.CatMapper;
import com.looye.mapper.CatMapper2;
import com.looye.repository.CatRepository;
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
    private CatMapper catMapper;

    @Resource
    private CatMapper2 catMapper2;

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

    public List<Cat> likeName(String name) {
        return catMapper.queryByName(name);
    }

    public List<Cat> queryByName(String name) {
        return catMapper2.queryByName(name);
    }

    public List<Cat> queryAll2() {
        return catMapper.queryAll();
    }

    @Transactional
    public void save(Cat cat) {
        catMapper.save(cat);
    }
}
