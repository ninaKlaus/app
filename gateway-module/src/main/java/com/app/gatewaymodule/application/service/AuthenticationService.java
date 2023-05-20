package com.app.gatewaymodule.application.service;

import cn.hutool.core.util.ObjectUtil;
import com.app.base.exception.BusinessException;
import com.app.gatewaymodule.application.dto.UserDTO;
import com.app.gatewaymodule.infrastructure.constant.GatewayConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author ninak
 */
@Service
public class AuthenticationService {

    @Resource
    private HttpSession session;

    public Boolean login(UserDTO user) {
        String vfCode = (String) session.getAttribute(GatewayConstant.VERIFY_CODE_KEY);
        return "admin".equals(user.getPassword()) && "admin".equals(user.getName());
    }
}
