package com.baizhi.advice;

import com.baizhi.entity.Log;

import java.util.Date;
import java.util.List;


/**
 * Created by DELL on 2018/1/14.
 */
public interface LogService {
    Log selectOne(String  l_id);
    List<Log> selectAll(Integer page, Integer rows);
    List<Log> selectByXXX(Integer page, Integer rows,
                         String username, String type,
                         Date start, Date end);
    void addLog(Log log);
    void dropLog(String  l_id);
    Integer selectTotalCount();
    Integer selectTotalCountByXXX(String username, String type,
                                  Date start, Date end);
}
