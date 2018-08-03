package com.baizhi.dao;

import com.baizhi.entity.Article;
import com.baizhi.entity.ObjectPage;

import java.util.List;

/**
 * Created by DELL on 2018/1/23.
 */
public interface LuceneDAO {
    void insertindex(Article article);
    void updateindex(String keyword, Article article);
    void deleteindex(String keyword);
    List<Article> query(String keyword);
    ObjectPage<Article> queryByPage(String keyword, Integer page, Integer rows);

}
