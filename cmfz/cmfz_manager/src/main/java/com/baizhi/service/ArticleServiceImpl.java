package com.baizhi.service;

import com.baizhi.annotation.Detail;
import com.baizhi.dao.ArticleDAO;
import com.baizhi.dao.LuceneDAO;
import com.baizhi.dao.LuceneDAOImpl;
import com.baizhi.entity.Article;
import com.baizhi.entity.ObjectPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by DELL on 2018/1/16.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    private LuceneDAO luceneDAO = new LuceneDAOImpl();
    @Resource
    private ArticleDAO articleDAO;
    @Resource
    private Jedis jedis;

    @Override
    @Detail
    public Article selectOne(String a_id) {
        return articleDAO.queryOne(a_id);
    }

    @Override
    @Detail("click")
    public Article click(String title) {
        Double score = jedis.zscore("articleName",title);
        if(score == null){
            jedis.zadd("articleName",1,title);
        }else {
            jedis.zincrby("articleName",1,title);

        }
        return articleDAO.queryOneByTitle(title);
    }

    @Override
    @Detail
    public Article selectOneByTitle(String title) {
        return articleDAO.queryOneByTitle(title);
    }

    @Override
    @Detail
    public Object zrank() {
        List<Article> articles = new LinkedList<Article>();
        Map<String ,Object> map = new HashMap<String ,Object>();

        List<String> names =new ArrayList<String>();
        List<String> counts = new ArrayList<String>();
        //反排序  返回所有value
        Set<String> zrangs = jedis.zrevrange("articleName",0,4);

        for(String title : zrangs){
            //根据文章名获得分数
            Double articleName = jedis.zscore("articleName", title);
            Integer value = articleName.intValue();
            counts.add(value.toString());
            names.add(title);
            System.out.println(title+"-----"+value);
        }
        map.put("names",names);
        map.put("data",counts);
        return map;
    }

    @Override
    @Detail
    public List<Article> selectAll(Integer page, Integer rows) {


        Integer pageStart = (page-1) *rows;
        return articleDAO.queryAll(pageStart,rows);
    }

    @Override
    @Detail
    public Integer selectTotalCount() {
        return articleDAO.queryTotalCount();
    }

    @Override
    @Detail("add")
    public void addArticle(Article article) {
        article.setA_id(UUID.randomUUID().toString());
        article.setA_state(true);
        article.setPublish_date(new Date());
        article.setHtml_url("a");

        luceneDAO.insertindex(article);

        articleDAO.insertArticle(article);

    }

    @Override
    @Detail
    public ObjectPage<Article> selectBySearch(String keyword, Integer page, Integer rows) {
        ObjectPage<Article> objectPage = null;

        objectPage = luceneDAO.queryByPage(keyword, page, rows);

        for (Article article : objectPage.getRows()) {
            System.out.println("数据库："+article);
            article=articleDAO.queryOneByTitle(article.getTitle());


        }

        return objectPage;
    }

}
