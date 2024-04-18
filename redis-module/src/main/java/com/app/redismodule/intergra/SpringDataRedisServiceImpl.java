package com.app.redismodule.intergra;

import com.app.redismodule.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SpringDataRedisServiceImpl implements SpringDataRedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();

        User user = new User();
        user.setName("zhangsan");
        user.setGender("male");


        valueOperations.set("app:data:cc:2", user);

        Object o = valueOperations.get("app:data:cc:2");
        System.out.println("o = " + o);

    }
}
