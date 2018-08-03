package com.baizhi.test;

import com.baizhi.dao.LuceneDAO;
import com.baizhi.dao.LuceneDAOImpl;
import com.baizhi.entity.Article;
import com.baizhi.entity.ObjectPage;
import com.baizhi.util.LuceneUtil;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;

/**
 * Created by DELL on 2018/1/24.
 */
public class TestLucene extends BaseTest{

//    @Resource
//    private LuceneDAO luceneDAO;

    @Test
    public void addArticle(){
        Article article = new Article();
        article.setTitle("龚尚志的故事");
        article.setAuthor("龚尚志");
        LuceneDAO luceneDAO = new LuceneDAOImpl();
        luceneDAO.insertindex(article);
    }

    @Test
    public void searchArticle(){
        LuceneDAO luceneDAO = new LuceneDAOImpl();
        ObjectPage<Article> objectPage = luceneDAO.queryByPage("啊", 1, 5);
        System.out.println("总"+objectPage.getTotal());
        for (Article article : objectPage.getRows()) {
            System.out.println(article);
        }

    }

    @Test
    public void analyzer() throws IOException {
        String s ="胡万余的故事";
        LuceneUtil.analyzerResult(new IKAnalyzer(),s);
    }



}
