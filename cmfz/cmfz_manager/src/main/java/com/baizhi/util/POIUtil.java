package com.baizhi.util;

import com.baizhi.entity.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 2018/1/15.
 */
public class POIUtil {
    public static <T> Workbook export(List<User> users, Class<T> class1)  {
        System.out.println("开始导出");
        // 1 创建excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 2 创建sheet
        HSSFSheet sheet = workbook.createSheet("104班就业喜报");
        // 准备数据
        String[] titles = {"编号", "账号", "密码", "头像", "法名", "昵称", "地址", "签名", "状态","年龄", "IP","注册日期","盐"};
        // 模拟数据库
        List<User> userList = users;
        System.out.println(userList);
        /**
         * 标题行
         */
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            // 创建单元格
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(titles[i]);
        }

        /**
         * 数据行
         */
        // 获得class对象
        /**
         * 1. User.class 2. Class.forName("com.baizhi.User") 3. new
         * User().getClass();
         */

        Class<?> userClass = null;
        try {
            userClass = Class.forName("com.baizhi.entity.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 获得所有属性
        Field[] fields = userClass.getDeclaredFields();
        System.out.println(fields.length);
        // 遍历集合
        for (int i = 0; i < userList.size(); i++) {

            // 创建行 跳过标题行
            HSSFRow row2 = sheet.createRow(i + 1);
            // 创建多少列 --- 跟对象的属性 -- 属性的个数 反射
            for (int j = 0; j < fields.length; j++) {
                // 创建单元格
                HSSFCell cell = row2.createCell(j);
                // 反射打破封装
                fields[j].setAccessible(true);

                // 设置单元格值 ---- 属性值
                System.out.println(i);
                System.out.println(userList.get(i));
                Object object = null;
                try {
                    object = fields[j].get(userList.get(i));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                if (object instanceof Date) {
                    Date date = (Date) object;
                    String val = new SimpleDateFormat("yyyy-MM-dd")
                            .format(date);
                    cell.setCellValue(val);
                } else {
                    cell.setCellValue(object.toString());
                }

            }
        }

        return workbook;

    }
}
