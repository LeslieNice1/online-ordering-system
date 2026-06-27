package com.order.system.controller;

import com.order.system.common.Result;
import com.order.system.entity.Menu;
import com.order.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public Result<List<Menu>> listByRestaurant(@RequestParam Long restaurantId) {
        List<Menu> list = menuService.lambdaQuery()
                .eq(Menu::getRestaurantId, restaurantId)
                .eq(Menu::getStatus, 1)
                .list();
        return Result.success(list);
    }

    @GetMapping("/{id}")
    public Result<Menu> getById(@PathVariable Long id) {
        return Result.success(menuService.getById(id));
    }
}
