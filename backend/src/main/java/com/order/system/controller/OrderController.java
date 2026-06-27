package com.order.system.controller;

import com.order.system.common.Result;
import com.order.system.entity.Order;
import com.order.system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Result<String> create(@RequestParam Long userId,
                                 @RequestParam Long restaurantId,
                                 @RequestParam Double totalAmount,
                                 @RequestParam String address,
                                 @RequestParam String phone) {
        String orderNo = orderService.createOrder(userId, restaurantId, totalAmount, address, phone);
        return Result.success(orderNo);
    }

    @GetMapping("/user/{userId}")
    public Result listByUser(@PathVariable Long userId) {
        return Result.success(orderService.lambdaQuery()
                .eq(Order::getUserId, userId)
                .list());
    }
}
