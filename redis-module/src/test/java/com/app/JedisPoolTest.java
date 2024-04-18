package com.app;

import com.app.redismodule.jedis.JedisConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class JedisPoolTest {
    private Jedis jedis;


    @Before
    void setUp() {
        jedis = JedisConnectionFactory.getJedis();
        jedis.select(1);
    }

    @Test
    void test() {
        String name = jedis.set("com:app:test:name:2", "阿里该多3");
        System.out.println("name = " + name);
        String s = jedis.get("com:app:test:name:2");
        System.out.println("s = " + s);
    }

    @Test
    void testHsah() {
        Map<String, String> map = new HashMap<>();
        map.put("age", "11");

        Long hset = jedis.hset("com:app:test:hashMap:name", map);
        System.out.println("name = " + hset);
        Map<String, String> stringStringMap = jedis.hgetAll("com:app:test:hashMap:name");
        stringStringMap.entrySet().forEach(
                c -> {
                    System.out.println(c.getKey() + "--" + c.getValue());
                }
        );
    }

    @After
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
