package com.app.usermodule.domain.user.service.impl;

import com.app.usermodule.domain.user.model.User;
import com.app.usermodule.domain.user.repository.UserMapper;
import com.app.usermodule.domain.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author ninak
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
