package com.baizhi.controller;

import com.baizhi.entity.ObjectPage;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2018/1/11.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("queryAll")
    @ResponseBody
    public ObjectPage<User> queryAll(Integer page,Integer rows){

        List<User> list = userService.selectAll(page,rows);
        ObjectPage<User> userPage = new ObjectPage<User>(list,userService.selectTotalCount());
        System.out.println(userPage);
        return userPage;
    }

    @RequestMapping("adds")
    @ResponseBody
    public String  adds(User user){
        List<User> users =new ArrayList<User>();
        users.add(user);
        System.out.println(users);
        userService.addUsers(users);
        return "ok";
    }

    @RequestMapping("/up")
    @ResponseBody
    public String up(MultipartFile source) throws IOException, ParseException {

        //1 通过流读入文件

        HSSFWorkbook workbook = new HSSFWorkbook(source.getInputStream());
        //2获得sheet
        HSSFSheet sheet = workbook.getSheet("104班就业喜报");
        //3获得总行数
        int lastRowNum = sheet.getLastRowNum();

        List<User> users = new ArrayList<User>();
        System.out.println(lastRowNum);
        //遍历
        for (int i = 1; i <= lastRowNum; i++) {
            HSSFRow row = sheet.getRow(i);
            User user = new User();

            user.setMobilephone(row.getCell(1).getStringCellValue());
            user.setPassword(row.getCell(2).getStringCellValue());
            user.setHead_portrait(row.getCell(3).getStringCellValue());
            user.setB_name(row.getCell(4).getStringCellValue());
            user.setUsername(row.getCell(5).getStringCellValue());
            user.setAddress(row.getCell(6).getStringCellValue());
            user.setSignature(row.getCell(7).getStringCellValue());

            user.setAge(22);
            user.setU_ip(row.getCell(9).getStringCellValue());


            users.add(user);
        }
        userService.addUsers(users);
        return "ok";
    }

    @RequestMapping("/down")
    @ResponseBody
    public void down(HttpServletResponse response) throws ClassNotFoundException, IOException, IllegalAccessException {

        Workbook wb = userService.export();

        // 准备输出�?
        ServletOutputStream os = null;
        try {
            os = response.getOutputStream();
            // 设置下载响应类型
            response.setContentType("application/force-download");
            // 设置响应头
            response.setHeader("content-disposition", "attachment; fileName="
                    + new String(("用户信息表.xls").getBytes(), "UTF-8"));

            wb.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
