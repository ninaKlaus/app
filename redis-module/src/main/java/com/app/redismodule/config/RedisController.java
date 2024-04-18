package com.app.redismodule.config;

import com.app.base.response.Response;
import com.app.redismodule.intergra.SpringDataRedisService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author ninak
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private SpringDataRedisService springDataRedisService;

    @GetMapping("/test")
    public Response<Boolean> login() {
        springDataRedisService.test();
        return Response.success(Boolean.TRUE);
    }
}
