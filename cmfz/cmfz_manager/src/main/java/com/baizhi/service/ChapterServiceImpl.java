package com.baizhi.service;

import com.baizhi.annotation.Detail;
import com.baizhi.entity.Chapter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by DELL on 2018/1/18.
 */
@Service
@Transactional
public class ChapterServiceImpl implements  Chapterervice {
    @Override
    @Detail
    public Chapter selectOne(String a_id) {
        return null;
    }

    @Override
    @Detail
    public Chapter selectOneByName(String name) {
        return null;
    }

    @Override
    @Detail
    public List<Chapter> selectAll(Integer page, Integer rows) {
        return null;
    }

    @Override
    @Detail
    public Integer selectTotalCount() {
        return null;
    }
}
