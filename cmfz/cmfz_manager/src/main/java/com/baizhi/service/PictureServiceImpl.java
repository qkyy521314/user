package com.baizhi.service;

import com.baizhi.annotation.Detail;
import com.baizhi.dao.PictureDAO;
import com.baizhi.entity.Picture;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by DELL on 2018/1/10.
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Resource
    private PictureDAO pictureDAO;
    @Override
    @Detail
    public Picture selectOne(String  p_id) {
        return pictureDAO.queryOne(p_id);
    }

    @Override
    @Detail
    public List<Picture> selectAll(Integer page,Integer rows) {

        Integer pageStart = (page-1) * rows;
        return pictureDAO.queryAll(pageStart,rows);
    }

    @Override
    @Detail("add")
    public void addPicture(Picture picture) {
        pictureDAO.insertPicture(picture);
    }

    @Override
    @Detail("delete")
    public void dropPicture(String  p_id) {
        pictureDAO.deletePicture(p_id);
    }

    @Override
    @Detail("update")
    public void changePicture(Picture picture) {
        pictureDAO.updatePicture(picture);
    }

    @Override
    @Detail
    public Integer selectTotalCount() {
        return pictureDAO.queryTotalCount();
    }
}
