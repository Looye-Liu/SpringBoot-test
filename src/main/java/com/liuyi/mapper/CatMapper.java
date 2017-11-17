package com.liuyi.mapper;

import com.liuyi.entity.Cat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by looye on 2017/11/17.
 */
@Mapper
@Component(value = "catMapper")
public interface CatMapper {

    @Select("select id,cat_age catAge,cat_name catName, colour from cat where cat_name = #{name}")
    List<Cat> likeName(String name);

    @Select("select id,cat_age catAge,cat_name catName, colour  from cat")
    List<Cat> queryAll();
}
