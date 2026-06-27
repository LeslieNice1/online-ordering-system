package com.order.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("menu")
public class Menu {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long restaurantId;
    private String name;
    private String description;
    private Double price;
    private String image;
    private Integer category; // 1-主食 2-小吃 3-饮料 4-套餐
    private Integer status; // 0-下架 1-在售

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableLogic
    private Integer deleted;
}
