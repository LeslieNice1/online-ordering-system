package com.order.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.order.system.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> selectByRestaurantId(@Param("restaurantId") Long restaurantId);
}
