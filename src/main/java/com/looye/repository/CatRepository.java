package com.looye.repository;

import com.looye.entity.Cat;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by looye on 2017/11/14.
 */
public interface CatRepository extends CrudRepository<Cat, Integer> {
}
