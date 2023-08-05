package com.app.gatewaymodule.application.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import com.app.base.exception.BusinessException;
import com.app.gatewaymodule.application.dto.UserDTO;
import com.app.gatewaymodule.infrastructure.constant.GatewayConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("12");


        HashMap<List<UserDTO>, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put( CollUtil.newArrayList(userDTO),"1");
        objectObjectHashMap.put( CollUtil.newArrayList(userDTO),"2");
        objectObjectHashMap.put( CollUtil.newArrayList(userDTO),"3");
        objectObjectHashMap.put( CollUtil.newArrayList(userDTO),"4");
        System.out.println("objectObjectHashMap = " + objectObjectHashMap.size());

    }
}
