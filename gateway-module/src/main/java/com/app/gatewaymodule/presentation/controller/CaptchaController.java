package com.app.gatewaymodule.presentation.controller;


import com.app.gatewaymodule.application.service.CaptchaGenerateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ninak
 */
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @Resource
    private CaptchaGenerateService captchaGenerateService;

    @GetMapping("/get_code")
    public void getCaptchaCode() {
        captchaGenerateService.getCaptchaCode();
    }


}
