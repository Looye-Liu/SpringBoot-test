package com.looye.entity;

import javax.persistence.*;

/**
 * 当JPA检测到有@Entity注解的时候，会在数据库中生成对应的表结构
 * <p>
 * 使用@Id注解指定主键
 * 使用@GeneratedValue(strategy = GenerationType.AUTO)注解指定主键为自动生成
 * Created by looye on 2017/11/14.
 */
@Entity
@Table(name = "cat")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String catName;
    private int catAge;
    private String colour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatAge() {
        return catAge;
    }

    public void setCatAge(int catAge) {
        this.catAge = catAge;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
