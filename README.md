# 线上订餐系统

基于 Spring Boot + Vue 3 的全栈订餐平台，支持用户浏览餐厅、查看菜单、加入购物车、提交订单等功能。

## 技术栈

### 后端
- Java 17 + Spring Boot 3.2
- MyBatis-Plus
- MySQL 8.0
- JWT 认证
- Lombok

### 前端
- Vue 3 + Vite
- Element Plus
- Axios
- Vue Router

## 项目结构

```
online-ordering-system/
├── backend/          # Spring Boot 后端
│   ├── src/main/java/com/order/system/
│   │   ├── controller/   # 控制器层
│   │   ├── service/      # 业务逻辑层
│   │   ├── mapper/       # 数据访问层
│   │   ├── entity/       # 实体类
│   │   └── config/       # 配置类
│   ├── sql/init.sql     # 数据库初始化脚本
│   └── pom.xml
└── frontend/         # Vue 3 前端
    ├── src/
    │   ├── views/       # 页面组件
    │   ├── router/      # 路由配置
    │   ├── api/         # 接口调用
    │   ├── App.vue
    │   └── main.js
    ├── package.json
    └── vite.config.js
```

## 快速启动

### 1. 后端启动

```bash
# 创建数据库
mysql -u root -p < backend/sql/init.sql

# 修改 application.yml 中的数据库密码

# 启动后端
cd backend
mvn spring-boot:run
# 后端运行在 http://localhost:8080
```

### 2. 前端启动

```bash
cd frontend
npm install
npm run dev
# 前端运行在 http://localhost:5173
```

## 功能模块

| 模块 | 功能 |
|------|------|
| 用户模块 | 注册、登录 |
| 餐厅模块 | 餐厅列表、餐厅详情 |
| 菜单模块 | 菜单列表、菜单详情 |
| 购物车 | 加入购物车、购物车管理 |
| 订单模块 | 创建订单、订单列表 |

## 接口说明

| 接口 | 方法 | 说明 |
|------|------|------|
| `/api/user/login` | POST | 用户登录 |
| `/api/user/register` | POST | 用户注册 |
| `/api/restaurant/list` | GET | 餐厅列表 |
| `/api/menu/list?restaurantId=` | GET | 菜单列表 |
| `/api/order/create` | POST | 创建订单 |

## 作者

曹成 - 2026 届本科应届生 - 湖南涉外经济学院 - 数据科学与大数据技术专业

##  license

MIT
