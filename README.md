# 🍔 线上订餐系统

> 一个基于 Spring Boot + Vue 3 的线上订餐平台，支持餐厅浏览、菜单查看、购物车、在线下单等功能。

## ✨ 功能特性

- 🏠 **餐厅浏览**：查看周边热门餐厅，支持评分、销量排序
- 📋 **菜单查看**：浏览餐厅详细菜单，支持菜品分类
- 🛒 **购物车**：添加菜品到购物车，实时计算总价
- 📦 **在线下单**：填写配送地址和联系电话，提交订单
- 📋 **订单管理**：查看历史订单，跟踪订单状态

## 🛠 技术栈

### 后端
- Spring Boot 3.x
- MyBatis
- MySQL
- Redis（缓存）

### 前端
- Vue 3 (Composition API)
- Vite
- Element Plus
- Axios

## 🚀 快速启动

### 前端（无需后端即可预览！）

本项目已内置**演示数据**，无需配置后端和数据库即可查看完整界面效果！

```bash
# 1. 克隆项目
git clone https://github.com/LeslieNice1/online-ordering-system.git
cd online-ordering-system/frontend

# 2. 安装依赖
npm install

# 3. 启动开发服务器
npm run dev
```

访问：http://localhost:5173/ 即可查看完整界面！

### 后端（可选，完整功能需要）

```bash
# 1. 配置数据库（MySQL 8.0+）
# 创建数据库：online_ordering
# 导入 backend/src/main/resources/schema.sql

# 2. 修改配置文件
# 编辑 backend/src/main/resources/application.properties
# 填写你的数据库用户名和密码

# 3. 启动后端
cd backend
mvn spring-boot:run
```

后端运行在：http://localhost:8080/

## 📸 界面预览

### 首页 - 热门餐厅
![首页](./screenshots/home.png)

### 餐厅详情 - 菜单与购物车
![餐厅详情](./screenshots/restaurant.png)

### 我的订单
![订单页](./screenshots/orders.png)

## 📂 项目结构

```
online-ordering-system/
├── backend/                # Spring Boot 后端
│   ├── src/main/java/      # Java 源代码
│   ├── src/main/resources/ # 配置文件
│   └── pom.xml            # Maven 配置
└── frontend/              # Vue 3 前端
    ├── src/views/          # 页面组件
    ├── src/router/        # 路由配置
    └── package.json       # npm 配置
```

## 🎯 核心功能讲解（面试必备）

### 1. 购物车状态管理
使用 Vue 响应式数组管理购物车数据，同时持久化到 localStorage：

```javascript
const cart = ref(JSON.parse(localStorage.getItem('cart') || '[]'))

function addToCart(item) {
  // 更新 cart 数组
  localStorage.setItem('cart', JSON.stringify(cart.value))
}
```

### 2. RESTful API 设计
遵循 REST 规范设计接口：

```
GET    /api/restaurant/list     获取餐厅列表
GET    /api/restaurant/{id}     获取餐厅详情
GET    /api/menu/list?rid={id} 获取菜单
POST   /api/order/create       创建订单
GET    /api/order/user/{id}    查询用户订单
```

### 3. 订单创建流程
涉及多个步骤：校验购物车 → 计算金额 → 锁定库存 → 生成订单号 → 扣减库存

## 📧 联系我

- GitHub：[@LeslieNice1](https://github.com/LeslieNice1)
- 邮箱：xxxx@example.com

---

⭐ 如果这个项目对你有帮助，欢迎给个 Star！
