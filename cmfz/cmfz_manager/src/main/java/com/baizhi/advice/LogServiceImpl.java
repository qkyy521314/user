package com.baizhi.advice;

import com.baizhi.dao.LogDAO;
import com.baizhi.entity.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 2018/1/14.
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Resource
    private LogDAO logDAO;
    @Override
    public Log selectOne(String l_id) {
        return logDAO.queryOne(l_id);
    }

    @Override
    public List<Log> selectAll(Integer page, Integer rows) {
        Integer pageStart = (page-1)*rows;
        return logDAO.queryAll(pageStart,rows);
    }

    @Override
    public List<Log> selectByXXX(Integer page, Integer rows, String username, String type, Date start, Date end) {
        Integer pageStart = (page-1)*rows;
        return logDAO.queryByXXX(pageStart,rows,username,type,start,end);
    }

    @Override
    public void addLog(Log log) {
        logDAO.insertLog(log);
    }

    @Override
    public void dropLog(String l_id) {
            logDAO.deleteLog(l_id);
    }

    @Override
    public Integer selectTotalCount() {
        return logDAO.queryTotalCount();
    }

    @Override
    public Integer selectTotalCountByXXX(String username, String type, Date start, Date end) {
        return logDAO.queryTotalCountByXXX(username,type,start,end);
    }
}
