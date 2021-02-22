package com.haoer.test.datasource.mapper;

import com.haoer.test.datasource.example.EntityExample;

import java.util.List;

public interface BaseMapper<T> {

    T selectById(java.io.Serializable id);

    List<T> selectByExample(EntityExample example);

    Integer selectCountByExample(EntityExample example);

    int insertSelective(T t);

    int insertBatch(List<T> ts);

    int updateById(T t);

    int updateByExample(T t);
}
