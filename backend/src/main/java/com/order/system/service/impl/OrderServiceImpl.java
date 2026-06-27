package com.order.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order.system.entity.Order;
import com.order.system.mapper.OrderMapper;
import com.order.system.service.OrderService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public String createOrder(Long userId, Long restaurantId, Double totalAmount, String address, String phone) {
        String orderNo = "ORD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setUserId(userId);
        order.setRestaurantId(restaurantId);
        order.setTotalAmount(totalAmount);
        order.setAddress(address);
        order.setPhone(phone);
        order.setStatus(0); // 待支付
        order.setCreateTime(LocalDateTime.now());
        save(order);
        return orderNo;
    }
}
