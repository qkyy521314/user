package com.baizhi.service;

import com.baizhi.entity.Special;

import java.util.List;

/**
 * Created by DELL on 2018/1/18.
 */
public interface SpecialService {
    Special selectOne(String a_id);
    Special selectOneByName(String  name);
    List<Special> selectAll(Integer page, Integer rows);
    Integer selectTotalCount();
}
