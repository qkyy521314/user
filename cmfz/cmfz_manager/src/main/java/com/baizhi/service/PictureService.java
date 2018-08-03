package com.baizhi.service;


import com.baizhi.entity.Picture;

import java.util.List;

/**
 * Created by DELL on 2018/1/10.
 */
public interface PictureService {
    Picture selectOne(String  p_id);
    List<Picture> selectAll(Integer page,Integer rows);
    void addPicture(Picture picture);
    void dropPicture(String  p_id);
    void changePicture(Picture picture);
    Integer selectTotalCount();
}
