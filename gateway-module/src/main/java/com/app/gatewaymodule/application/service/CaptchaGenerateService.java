package com.app.gatewaymodule.application.service;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ninak
 */
@Service
public class CaptchaGenerateService {

    @Resource
    private HttpSession session;
    @Resource
    private HttpServletResponse response;


    public void getCaptchaCode() {
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 5);
        String code = captcha.getCode();
        session.setAttribute("code", code);
        try {
            captcha.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
