package com.order.system.controller;

import com.order.system.common.Result;
import com.order.system.entity.User;
import com.order.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<User> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        if (user != null) {
            return Result.success(user);
        }
        return Result.error("用户名或密码错误");
    }

    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody User user) {
        boolean success = userService.register(user);
        if (success) {
            return Result.success(true);
        }
        return Result.error("用户名已存在");
    }

    @GetMapping("/{id}")
    public Result<User> getById(@PathVariable Long id) {
        return Result.success(userService.getById(id));
    }
}
