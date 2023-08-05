package com.app.usermodule.domain.user.service.impl;

import com.app.base.exception.BusinessException;
import com.app.usermodule.domain.user.model.User;
import com.app.usermodule.domain.user.repository.UserMapper;
import com.app.usermodule.domain.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ninak
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void test() {
    }


        public static void main(String[] args) {
            ArrayList<String> list1 = new ArrayList<>();
            list1.add("1");
            list1.add("4");
            list1.add("5");

            ArrayList<String> list2 = new ArrayList<>();
            list2.add("3");
            list2.add("4");
            list2.add("5");

            boolean b = CollectionUtils.containsAny(list1, list2);

            if (b) {
                System.out.println("两个ArrayList存在交集");
            } else {
                System.out.println("两个ArrayList不存在交集");
            }
        }

}
