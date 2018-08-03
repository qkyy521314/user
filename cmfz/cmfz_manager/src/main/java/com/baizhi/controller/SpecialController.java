package com.baizhi.controller;

import com.baizhi.service.SpecialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by DELL on 2018/1/18.
 */
@Controller
@RequestMapping("special")
public class SpecialController {

    @Resource
    private SpecialService specialService;

    @RequestMapping(value = "/si/{a_id}/{u_id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> si(@PathVariable("s_id")String s_id, @PathVariable("u_id")String u_id){

        return null;
    }
}
