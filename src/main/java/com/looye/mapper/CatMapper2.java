package com.looye.mapper;

import com.looye.entity.Cat;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by looye on 2017/11/20.
 *
 * @author looye
 * @date 2017/11/20
 */
@Component
public interface CatMapper2 {

    /**
     * 按名称查询
     *
     * @param name
     * @return
     */
    List<Cat> queryByName(@Param("name") String name);

}
