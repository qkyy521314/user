package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DELL on 2018/1/12.
 */
public interface UserDAO {
    List<User> queryAll(@Param(value = "pageStart")Integer pageStart,@Param(value = "rows")Integer rows);
    User queryOneByMobilephone(String mobilephone);
    void insertUsers(List<User> users);
    void deleteUser(String u_id);
    void updateUser(User user);
    Integer queryTotalCount();
}
