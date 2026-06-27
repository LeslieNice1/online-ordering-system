-- 线上订餐系统 数据库初始化脚本
CREATE DATABASE IF NOT EXISTS online_ordering
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE online_ordering;

-- 用户表
CREATE TABLE user
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    username     VARCHAR(50)  NOT NULL UNIQUE,
    password     VARCHAR(100) NOT NULL,
    nickname     VARCHAR(50),
    phone        VARCHAR(20),
    email        VARCHAR(100),
    avatar       VARCHAR(255),
    role         INT         DEFAULT 0 COMMENT '0-普通用户 1-商家 2-管理员',
    create_time  DATETIME    DEFAULT CURRENT_TIMESTAMP,
    update_time  DATETIME    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted      INT         DEFAULT 0
);

-- 商家/餐厅表
CREATE TABLE restaurant
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    description  VARCHAR(500),
    image        VARCHAR(255),
    address      VARCHAR(255),
    phone        VARCHAR(20),
    score        DOUBLE      DEFAULT 0,
    sales        INT         DEFAULT 0,
    status       INT         DEFAULT 1 COMMENT '0-歇业 1-营业',
    create_time  DATETIME    DEFAULT CURRENT_TIMESTAMP,
    update_time  DATETIME    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted      INT         DEFAULT 0
);

-- 菜单表
CREATE TABLE menu
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id BIGINT      NOT NULL,
    name          VARCHAR(100) NOT NULL,
    description   VARCHAR(500),
    price         DOUBLE      NOT NULL,
    image         VARCHAR(255),
    category      INT         DEFAULT 1 COMMENT '1-主食 2-小吃 3-饮料 4-套餐',
    status        INT         DEFAULT 1 COMMENT '0-下架 1-在售',
    create_time   DATETIME    DEFAULT CURRENT_TIMESTAMP,
    update_time   DATETIME    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted       INT         DEFAULT 0
);

-- 订单表
CREATE TABLE orders
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_no      VARCHAR(50)  NOT NULL UNIQUE,
    user_id       BIGINT       NOT NULL,
    restaurant_id BIGINT,
    total_amount  DOUBLE      NOT NULL,
    status        INT         DEFAULT 0 COMMENT '0-待支付 1-已支付 2-配送中 3-已完成 4-已取消',
    address       VARCHAR(255),
    phone         VARCHAR(20),
    remark        VARCHAR(500),
    create_time   DATETIME    DEFAULT CURRENT_TIMESTAMP,
    update_time   DATETIME    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted       INT         DEFAULT 0
);

-- 插入测试数据
INSERT INTO user (username, password, nickname, phone, role)
VALUES ('admin', '123456', '管理员', '13800000000', 2),
       ('user1', '123456', '张三', '13800000001', 0);

INSERT INTO restaurant (name, description, image, address, phone, score, sales, status)
VALUES ('肯德基', '美味炸鸡，快到碗里来', 'https://example.com/kfc.jpg', '长沙市岳麓区xxx路', '0731-88888888', 4.5, 1000, 1),
       ('麦当劳', 'i m lovin it', 'https://example.com/mcd.jpg', '长沙市岳麓区yyy路', '0731-99999999', 4.3, 800, 1);

INSERT INTO menu (restaurant_id, name, description, price, image, category, status)
VALUES (1, '香辣鸡腿堡', '经典香辣鸡腿堡', 18.00, 'https://example.com/burger.jpg', 1, 1),
       (1, '薯条（中）', '金黄酥脆薯条', 12.00, 'https://example.com/fries.jpg', 2, 1),
       (1, '可乐（中）', '冰爽可口可乐', 8.00, 'https://example.com/cola.jpg', 3, 1),
       (2, '巨无霸', '双层牛肉巨无霸', 22.00, 'https://example.com/bigmac.jpg', 1, 1),
       (2, '麦辣鸡翅', '香辣鸡翅4块', 15.00, 'https://example.com/wings.jpg', 2, 1);
