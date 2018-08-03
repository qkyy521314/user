package com.baizhi.test;

import com.baizhi.advice.LogService;
import com.baizhi.dao.ArticleDAO;
import com.baizhi.entity.Article;
import com.baizhi.service.MenuService;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
/**
 * Created by DELL on 2018/1/8.
 */

public class TestService extends BaseTest {
    @Resource
    private MenuService menuService;
    @Resource
    private Jedis jedis;
    @Resource
    private LogService logService;
    @Resource
    private ArticleDAO articleDAO;
    @Test
    public void add() {
        Article article = articleDAO.queryOneByTitle("aa");
        System.out.print(article);
        System.out.println();

    }

    @Test
    public void see() {
        Article article = articleDAO.queryOneByTitle("胡万余的故事");
        System.out.println(article);
    }

    @Test
    public void addscoer() {
        jedis.zadd("articleName",1,"aa");
        jedis.zadd("articleName",5,"bb");
        jedis.zadd("articleName",8,"cc");
        jedis.zadd("articleName",3,"dd");
        jedis.zadd("articleName",19,"ee");


//        jedis.zadd("a",1,"a1");
//        Double score =jedis.zscore("a","a1");
//        jedis.zincrby("a",1,"a1");
//        jedis.zincrby("a",1,"a1");
//        jedis.zincrby("a",1,"a1"); jedis.zincrby("a",1,"a1");
//
//        Double s=jedis.zscore("a","a1");
//        System.out.println("----"+s);
//        Long zrank = jedis.zrank("a", "a1");
//        System.out.println(zrank);

    }

}
