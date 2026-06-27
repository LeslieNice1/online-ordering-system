package com.order.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.order.system.entity.Order;

public interface OrderService extends IService<Order> {
    String createOrder(Long userId, Long restaurantId, Double totalAmount, String address, String phone);
}
