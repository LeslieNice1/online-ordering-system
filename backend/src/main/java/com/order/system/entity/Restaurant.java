package com.order.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("restaurant")
public class Restaurant {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String image;
    private String address;
    private String phone;
    private Double score;
    private Integer sales;
    private Integer status; // 0-歇业 1-营业

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableLogic
    private Integer deleted;
}
