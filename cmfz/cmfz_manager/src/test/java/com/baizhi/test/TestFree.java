package com.baizhi.test;


import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

/**
 * Created by DELL on 2018/1/15.
 */
public class TestFree {
    public static void main(String[] args) throws Exception {
        //使用配置类
        Configuration configuration =new Configuration();
        //设置ftl文件位置
        configuration.setDirectoryForTemplateLoading(new File("E:\\idea\\cmfz\\cmfz_manager\\src\\test\\resources\\ftl"));
        //设置编码
        configuration.setDefaultEncoding("UTF-8");
        //设置模板
        Template template =configuration.getTemplate("article.ftl");
        //准备数据
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("title","我是标题");
        map.put("author","作者");

        FileWriter fileWriter = new FileWriter(new File("E:\\idea\\cmfz\\cmfz_manager\\src\\main\\webapp\\back\\html\\article.html"));

        //生产静态页面
        template.process(map,fileWriter);

        //释放资源
        fileWriter.flush();
        fileWriter.close();
    }
}
