package com.liuyi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 当JPA检测到有@Entity注解的时候，会在数据库中生成对应的表结构
 * <p>
 * 使用@Id注解指定主键
 * 使用@GeneratedValue(strategy = GenerationType.AUTO)注解指定主键为自动生成
 * Created by looye on 2017/11/14.
 */
@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cateName;
    private int cateAge;
    private String colour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getCateAge() {
        return cateAge;
    }

    public void setCateAge(int cateAge) {
        this.cateAge = cateAge;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
