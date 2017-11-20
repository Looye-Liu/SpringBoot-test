package com.looye.dao;

import com.looye.entity.Cat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 使用@Respository注解，标注这是一个持久化对象
 * <p>
 * Created by looye on 2017/11/15.
 */
@Repository
public class CatDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public Cat selectByCatName(String catName) {

        //1、定一个sql
        String sql = "select * from cat where cat_name = ?";

        //2、定一个RowMapper
        RowMapper<Cat> rowMapper = new BeanPropertyRowMapper<>(Cat.class);

        //3、查询
        Cat cat = jdbcTemplate.queryForObject(sql, new Object[]{catName}, rowMapper);
        return cat;
    }

    public Cat selectByCatColour(String colour) {

        //1、定一个sql
        String sql = "select * from cat where colour = ?";

        //2、定一个RowMapper
        RowMapper<Cat> rowMapper = new BeanPropertyRowMapper<>(Cat.class);

        //3、查询
        Cat cat = jdbcTemplate.queryForObject(sql, new Object[]{colour}, rowMapper);
        return cat;
    }


    public List<Cat> selectByCatColour2(String colour) {
        //1、定一个sql
        String sql = "select * from cat where colour = ?";

        //2、定一个RowMapper
        RowMapper<Cat> rowMapper = new BeanPropertyRowMapper<>(Cat.class);

        //3、查询
        List<Cat> catList = jdbcTemplate.query(sql, new Object[]{colour}, rowMapper);
        return catList;
    }
}
