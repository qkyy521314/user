package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.entity.ObjectPage;
import com.baizhi.service.ArticleService;
import com.baizhi.util.FreeMarkerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2018/1/16.
 */
@Controller
@RequestMapping("article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("queryAll")
    @ResponseBody
    private ObjectPage<Article> queryAll(Integer page,Integer rows,String name,String value){
        ObjectPage<Article> articleObject = null;
        System.out.println(name+"---"+value);
        if("keyword".equals(name)&& value!=""){
            articleObject =articleService.selectBySearch(value,page,rows);

        }else {
            List<Article> list = articleService.selectAll(page,rows);
            articleObject = new ObjectPage<Article>(list,articleService.selectTotalCount());

        }
        System.out.println(articleObject);
        return articleObject;
    }

    @RequestMapping("add")
    @ResponseBody
    private String addArticle(Article article){
        System.out.println("------");
        articleService.addArticle(article);

        return "ok";
    }
    @RequestMapping("click")
    @ResponseBody
    public String click(String title){
        articleService.click(title);
        return "ok";
    }
    @RequestMapping("create")
    @ResponseBody
    private String createHTML(String title){
        System.out.println(title);
        Article article = articleService.selectOneByTitle(title);
        System.out.println("-----"+article);
        if(FreeMarkerUtil.createHTML(article)){
            return "ok";
        }
        return "false";
    }

    @RequestMapping("rank")
    @ResponseBody
    public Object rank(){
        Map<String ,Object> map =new HashMap<String,Object>();
            try {
                return articleService.zrank();
            }catch (Exception e){
                e.printStackTrace();
                map.put("success",false);
                map.put("message","error");
                return map;
            }
    }

    @RequestMapping(value = "/wen/{a_id}/{u_id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> wen(@PathVariable("a_id")String a_id,@PathVariable("u_id")String u_id){
        Map<String,Object> map = new HashMap<String, Object>();
        Article article = articleService.selectOne(a_id);

        map.put("link", article.getHtml_url());
        map.put("id",article.getA_id());
        map.put("ext",null);
        return map;
    }
}
