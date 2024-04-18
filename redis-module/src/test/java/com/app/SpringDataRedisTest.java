package com.app;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;


@SpringBootTest
public class SpringDataRedisTest {

    @Resource
    private RedisTemplate redisTemplate;


    @Test
    public void test(){

        ValueOperations valueOperations = redisTemplate.opsForValue();


        valueOperations.set("data:cc:1","zhangsan1111");

        Object o = valueOperations.get("data:cc:1");
        System.out.println("o = " + o);

    }
}
