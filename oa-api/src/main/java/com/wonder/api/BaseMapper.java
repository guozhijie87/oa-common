package com.wonder.api;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Guozhijie on 2017/2/16.
 */
public interface BaseMapper<T> {
    int countByExample(T example);

    int deleteByMap(Map<String,Object> hashMap);

    int delete(long id);

    int insert(T record);

    List<T> selectListByMap(Map<String,Object> hashMap);

    T selectByMap(Map<String,Object> hashMap);

    T selectById(Long id);

    int updateById(T t);

    int updateByMap(Map<String,Object> hashMap);

}
