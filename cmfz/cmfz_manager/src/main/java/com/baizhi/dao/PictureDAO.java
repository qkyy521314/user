package com.baizhi.dao;

import com.baizhi.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DELL on 2018/1/10.
 */
public interface PictureDAO {
    Picture queryOne(String  p_id);
    List<Picture> queryAll(@Param(value="pageStart")Integer pageStart, @Param(value="rows")Integer rows);
    void insertPicture(Picture picture);
    void updatePicture(Picture picture);
    void deletePicture(String  p_id);
    Integer queryTotalCount();
}
