package com.baizhi.dao;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DELL on 2018/1/16.
 */
public interface ArticleDAO {
    Article queryOne(String a_id);
    Article queryOneByTitle(String title);
    void insertArticle(Article article);
    List<Article> queryAll(@Param(value="pageStart")Integer pageStart, @Param(value="rows")Integer rows);
    Integer queryTotalCount();
}
