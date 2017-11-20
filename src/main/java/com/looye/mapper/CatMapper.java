package com.looye.mapper;

import com.looye.entity.Cat;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by looye on 2017/11/17.
 */
@Component(value = "catMapper")
public interface CatMapper {

    @Select("<script>select id,cat_age ,cat_name, colour from cat " +
            "where 1=1" +
            "<if test='name != null'>" +
            " and cat_name = #{name} " +
            "</if>" +
            "</script>")
    @Results({
            @Result(property = "catAge", column = "cat_age"),
            @Result(property = "catName", column = "cat_name")
    })
    List<Cat> queryByName(@Param("name") String name);

    @Select("select id,cat_age catAge,cat_name catName, colour  from cat")
    List<Cat> queryAll();

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into cat(cat_name,cat_age,colour) values(#{catName},#{catAge},#{colour})")
    void save(Cat cat);
}
