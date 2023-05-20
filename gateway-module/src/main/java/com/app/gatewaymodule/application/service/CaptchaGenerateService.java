package com.app.gatewaymodule.application.service;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.app.gatewaymodule.infrastructure.constant.GatewayConstant;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @author ninak
 */
@Service
public class CaptchaGenerateService {

    public String getCaptchaCode(HttpSession session) {
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(100, 40, 4, 5);
        String code = captcha.getCode();
        session.setAttribute(GatewayConstant.VERIFY_CODE_KEY, code);
        String base64Img = "";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(captcha.getImage(), "png", outputStream);
            byte[] bytes = outputStream.toByteArray();
            base64Img = Base64.getEncoder().encodeToString(bytes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Img;
    }

}
