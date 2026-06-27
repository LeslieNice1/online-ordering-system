package com.order.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.order.system.mapper")
public class OrderingApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderingApplication.class, args);
    }
}
