package com.app.gatewaymodule.presentation.controller;


import com.app.base.response.Response;
import com.app.gatewaymodule.application.service.CaptchaGenerateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author ninak
 */
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @Resource
    private CaptchaGenerateService captchaGenerateService;

    @GetMapping("/get_code")
    public Response<String> getCaptchaCode(HttpSession session) {
        return Response.success(captchaGenerateService.getCaptchaCode(session));
    }

}
