package com.order.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order.system.entity.Restaurant;
import com.order.system.mapper.RestaurantMapper;
import com.order.system.service.RestaurantService;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl extends ServiceImpl<RestaurantMapper, Restaurant> implements RestaurantService {
}
