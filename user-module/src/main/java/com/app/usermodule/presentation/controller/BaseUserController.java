package com.app.usermodule.presentation.controller;

import com.app.base.response.Response;
import com.app.usermodule.application.service.UserApplicationService;
import com.app.usermodule.domain.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ninaklaus
 */
@Api(tags = "首页模块")
@RestController
@RequestMapping("/user/base/")
public class BaseUserController {

    @Resource
    private UserApplicationService userApplicationService;


    @ApiImplicitParam(name = "user", value = "用户信息")
    @ApiOperation(value = "新增用户")
    @PostMapping("/add")
    public Response<Boolean> addUser(@RequestBody User user) {
        return Response.success(Boolean.TRUE);
    }

    @ApiImplicitParam(name = "id", value = "用户id", required = true)
    @ApiOperation(value = "根据用户id查询用户信息")
    @GetMapping("/find/{id}")
    public Response<User> findUserById(@PathVariable("id") Integer id) {
        return Response.success(new User());
    }
}
