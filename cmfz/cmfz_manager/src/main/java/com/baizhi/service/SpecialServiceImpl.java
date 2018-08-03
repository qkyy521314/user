package com.baizhi.service;

import com.baizhi.entity.Special;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by DELL on 2018/1/18.
 */
@Service
@Transactional
public class SpecialServiceImpl implements SpecialService {
    @Override
    public Special selectOne(String a_id) {
        return null;
    }

    @Override
    public Special selectOneByName(String name) {
        return null;
    }

    @Override
    public List<Special> selectAll(Integer page, Integer rows) {
        return null;
    }

    @Override
    public Integer selectTotalCount() {
        return null;
    }
}
