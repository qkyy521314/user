package com.baizhi.controller;

import com.baizhi.advice.LogService;
import com.baizhi.entity.Log;
import com.baizhi.entity.ObjectPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by DELL on 2018/1/15.
 */
@Controller
@RequestMapping("log")
public class LogController {
    @Resource
    private LogService logService;

    @RequestMapping("queryAll")
    @ResponseBody
    public ObjectPage<Log> queryAll(Integer page, Integer rows,String name,String value){
        System.out.println(name+"---"+value);
        List<Log> list=null;
        Integer total=null;
        if("username".equals(name)&& value!=""){
            //System.out.println("hahha");
            list=logService.selectByXXX(page,rows,value,null,null,null);
            total = logService.selectTotalCountByXXX(value,null,null,null);
        }else if("type".equals(name)&& value!=""){
            list=logService.selectByXXX(page,rows,null,value,null,null);
            total = logService.selectTotalCountByXXX(null,value,null,null);
        }else if("end".equals(name)&& value!=""){
            list=logService.selectByXXX(page,rows,null,null,null,null);
            total = logService.selectTotalCountByXXX(null,null,null,null);
        }else {
            list = logService.selectAll(page,rows);
            total= logService.selectTotalCount();
        }

        ObjectPage<Log> logPage = new ObjectPage<Log>(list,total);
        System.out.println(logPage);
        return  logPage;
    }

}
