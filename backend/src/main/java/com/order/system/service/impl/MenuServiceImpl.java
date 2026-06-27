package com.order.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order.system.entity.Menu;
import com.order.system.mapper.MenuMapper;
import com.order.system.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}
