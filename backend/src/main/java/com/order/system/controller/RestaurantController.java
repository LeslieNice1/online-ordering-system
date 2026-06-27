package com.order.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.order.system.common.Result;
import com.order.system.entity.Restaurant;
import com.order.system.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/list")
    public Result<List<Restaurant>> list() {
        List<Restaurant> list = restaurantService.list(
                new LambdaQueryWrapper<Restaurant>()
                        .eq(Restaurant::getStatus, 1)
                        .orderByDesc(Restaurant::getSales)
        );
        return Result.success(list);
    }

    @GetMapping("/{id}")
    public Result<Restaurant> getById(@PathVariable Long id) {
        return Result.success(restaurantService.getById(id));
    }

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody Restaurant restaurant) {
        return Result.success(restaurantService.save(restaurant));
    }
}
