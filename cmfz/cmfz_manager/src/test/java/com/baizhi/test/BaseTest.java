package com.baizhi.test;

import com.baizhi.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Created by DELL on 2018/1/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class BaseTest {
    public static void main(String[] args) {

        Collections.synchronizedList(new ArrayList<Object>());
        Collections.synchronizedSortedSet(new TreeSet<Object>());
        Collections.synchronizedMap(new HashMap<Object, Object>());

    }
}
