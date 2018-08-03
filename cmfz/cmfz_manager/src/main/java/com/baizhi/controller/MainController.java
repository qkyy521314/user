package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.entity.Picture;
import com.baizhi.entity.Special;
import com.baizhi.service.ArticleService;
import com.baizhi.service.PictureService;
import com.baizhi.service.SpecialService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2018/1/17.
 */
@RequestMapping("main")
@ResponseBody
public class MainController {

    @Resource
    private PictureService pictureService;
    @Resource
    private ArticleService articleService;
    @Resource
    private SpecialService specialService;
    @RequestMapping(value = "main",method = RequestMethod.GET)
    public Map<String,Object> main(@PathVariable("u_id")String u_id,@PathVariable("type")String type,@PathVariable("sub_type")String sub_type){
        Map<String,Object> map = new HashMap<String, Object>();



        Map<String, Object> pictures = new HashMap<String, Object>();
        Map<String, Object> articles = new HashMap<String, Object>();
        Map<String, Object> specials = new HashMap<String, Object>();

        if(type.equals("all")){
            //查询首页
            List<Picture>  picture =  pictureService.selectAll(0,5);
            List<Article>  article =  articleService.selectAll(0,6);
            List<Special>  special =  specialService.selectAll(0,6);

            for(Picture p:picture) {
                pictures.put("thumbnail", p.getP_url());
                pictures.put("desc",p.getP_name());
                pictures.put("id",p.getP_id());
            }
            map.put("header",picture);
            for(Article a : article){
                articles.put("thumbnail",null);
                articles.put("title",a.getTitle());
                articles.put("author",a.getAuthor());
                articles.put("create_date",a.getPublish_date());
            }
            map.put("articles",articles);
            for(Special s : special){

            }
            map.put("specials",specials);
        }
        if(type == "wen"){
            List<Special>  special =  specialService.selectAll(0,6);
            for(Special s : special){

            }
            map.put("specials",specials);

        }
        if(type == "si"){
            List<Article>  article =  articleService.selectAll(0,6);
            for(Article a : article){
                articles.put("thumbnail",null);
                articles.put("title",a.getTitle());
                articles.put("author",a.getAuthor());
                articles.put("create_date",a.getPublish_date());
            }
            map.put("articles",articles);
            if(sub_type == "ssyj"){
            //返回上师言教数据
            }if(sub_type == "xmfy"){
                //返回显密法要的数据
            }
        }

        return null;
    }

}
