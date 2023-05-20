package com.app.gatewaymodule.presentation.controller;

import com.app.base.response.Response;
import com.app.gatewaymodule.application.dto.UserDTO;
import com.app.gatewaymodule.application.service.AuthenticationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ninak
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Resource
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public Response<Boolean> login(@RequestBody UserDTO userDTO) {
        return Response.success(authenticationService.login(userDTO));
    }
}
