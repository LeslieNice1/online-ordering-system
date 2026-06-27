package com.order.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order.system.entity.User;
import com.order.system.mapper.UserMapper;
import com.order.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User login(String username, String password) {
        User user = lambdaQuery()
                .eq(User::getUsername, username)
                .eq(User::getPassword, password)
                .one();
        return user;
    }

    @Override
    public boolean register(User user) {
        User exist = getByUsername(user.getUsername());
        if (exist != null) {
            return false;
        }
        return save(user);
    }

    @Override
    public User getByUsername(String username) {
        return lambdaQuery()
                .eq(User::getUsername, username)
                .one();
    }
}
