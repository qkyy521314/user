package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

/**
 * Created by DELL on 2018/1/18.
 */
public interface Chapterervice {
    Chapter selectOne(String a_id);
    Chapter selectOneByName(String  name);
    List<Chapter> selectAll(Integer page, Integer rows);
    Integer selectTotalCount();
}
