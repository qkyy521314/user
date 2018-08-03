package com.baizhi.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * Created by DELL on 2018/1/16.
 * @Configuration  该注解表示  可以通过该类获得其他bean
 */
@Configuration
public class JedisUtil {
    //该注解表示：方法返回值 放入bean工厂中
    @Bean
    public Jedis grtJedis(){

        return new Jedis("192.168.11.129",7000);
    }
}
