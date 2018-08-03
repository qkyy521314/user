package com.baizhi.controller;

import com.baizhi.advice.ManagerService;
import com.baizhi.entity.Manager;
import com.baizhi.util.VerifyCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * Created by DELL on 2018/1/11.
 */
@Controller
@RequestMapping("manager")
public class ManagerController {
    @Resource
    private ManagerService managerService;

    @RequestMapping("login")
    private String login(Manager manager,String enCode,HttpServletRequest req){

        String code = (String) req.getSession().getAttribute("code");

        if(code.equalsIgnoreCase(enCode)) {


           req.getSession().setAttribute("login", manager);
           managerService.login(manager, req.getSession());

        return "main";
        }
        return "login";
    }

    @RequestMapping("/imageCode")
    public void imageCode(HttpSession session, HttpServletResponse response) throws Exception{

        //获取验证码
        String generateVerifyCode = VerifyCodeUtil.generateVerifyCode(4);
        System.out.println(generateVerifyCode);
        session.setAttribute("code", generateVerifyCode);
        //放入图片中
        BufferedImage image = VerifyCodeUtil.getImage(100, 40,generateVerifyCode);
        //响应验证码
        response.setContentType("image/png");
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image, "png",os);
    }
}
