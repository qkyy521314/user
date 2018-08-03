package com.baizhi.service;

import com.baizhi.entity.Article;
import com.baizhi.entity.ObjectPage;

import java.util.List;

/**
 * Created by DELL on 2018/1/16.
 */
public interface ArticleService {
    Article selectOne(String a_id);
    Article click(String  title);//增加阅读量
    Article selectOneByTitle(String  title);
    Object zrank();
    List<Article> selectAll(Integer page, Integer rows);
    Integer selectTotalCount();
    void addArticle(Article article);
    ObjectPage<Article> selectBySearch(String keyword, Integer page, Integer rows);

}
