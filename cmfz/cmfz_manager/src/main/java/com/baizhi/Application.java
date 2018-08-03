package com.baizhi;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * Created by DELL on 2018/1/10.
 */

@SpringBootApplication
@MapperScan("com.baizhi.dao")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);

        Arrays.asList(1,2);
    }
}
