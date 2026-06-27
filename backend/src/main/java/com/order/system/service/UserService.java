package com.order.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.order.system.entity.User;

public interface UserService extends IService<User> {
    User login(String username, String password);
    boolean register(User user);
    User getByUsername(String username);
}
