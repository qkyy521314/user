package com.baizhi.dao;

import com.baizhi.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 2018/1/14.
 */
public interface LogDAO {
    Log queryOne(String  l_id);
    List<Log> queryAll(@Param(value="pageStart")Integer pageStart, @Param(value="rows")Integer rows);
    List<Log> queryByXXX(@Param(value="pageStart")Integer pageStart, @Param(value="rows")Integer rows,
                         @Param(value = "username")String username, @Param(value = "type")String type,
                         @Param(value = "start")Date start,@Param(value = "end")Date end);
    void insertLog(Log log);
    void deleteLog(String  l_id);
    Integer queryTotalCount();
    Integer queryTotalCountByXXX(@Param(value = "username")String username, @Param(value = "type")String type,
                                 @Param(value = "start")Date start,@Param(value = "end")Date end);
}
