package com.liuyi.repository;

import com.liuyi.entity.Cat;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by looye on 2017/11/14.
 */
public abstract class CatRepository implements CrudRepository<Cat, Integer> {
}
