<template>
  <div id="app">
    <el-container>
      <el-header class="header">
        <div class="header-left">
          <h2 @click="$router.push('/')">🍔 线上订餐系统</h2>
          <span class="header-sub">精选美食 · 极速送达 · 品质保障</span>
        </div>
        <div class="nav">
          <el-button :type="$route.path === '/' ? 'primary' : ''" round @click="$router.push('/')">
            🏠 首页
          </el-button>
          <el-button :type="$route.path === '/orders' ? 'primary' : ''" round @click="$router.push('/orders')">
            📋 我的订单
          </el-button>
        </div>
      </el-header>
      <el-main style="padding:0; background:#f5f7fa;">
        <router-view/>
      </el-main>
    </el-container>
  </div>
</template>

<script setup>
</script>

<style>
* { margin: 0; padding: 0; box-sizing: border-box; }
.header {
  background: linear-gradient(135deg, #ff512f, #dd2476);
  color: white;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 14px 30px !important;
}
.header-left h2 { cursor:pointer; font-size:22px; margin-bottom:2px; }
.header-sub { font-size:12px; opacity:0.8; }
.nav { display: flex; gap: 10px; }
</style>
