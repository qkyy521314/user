package com.baizhi.util;

import com.baizhi.entity.Article;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by DELL on 2018/1/16.
 */
public class FreeMarkerUtil {

    public static boolean createHTML(Article article){
        FileWriter fileWriter=null;
        try {
        //使用配置类
        Configuration configuration =new Configuration();
        //设置ftl文件位置
        configuration.setDirectoryForTemplateLoading(new File("E:\\idea\\cmfz\\cmfz_manager\\src\\main\\resources\\templates"));
        //设置编码
        configuration.setDefaultEncoding("UTF-8");
        //设置模板
        Template template =configuration.getTemplate("article.ftl");
        //准备数据
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("article",article);
            System.out.println("文章："+article);

        fileWriter = new FileWriter(new File("E:\\idea\\cmfz\\cmfz_manager\\src\\main\\webapp\\back\\html\\"+article.getTitle()+".html"));

        //生产静态页面
            try {
                template.process(map,fileWriter);
            } catch (TemplateException e) {
                e.printStackTrace();
            }

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
