<template>
  <div id="app">
    <el-container>
      <el-header>
        <div class="header">
          <h2 @click="$router.push('/')">线上订餐系统</h2>
          <div class="nav">
            <el-button text @click="$router.push('/')">首页</el-button>
            <el-button text @click="$router.push('/orders')">我的订单</el-button>
          </div>
        </div>
      </el-header>
      <el-main>
        <router-view/>
      </el-main>
    </el-container>
  </div>
</template>

<script setup>
</script>

<style>
body { margin: 0; padding: 0; }
.header { display: flex; justify-content: space-between; align-items: center; padding: 0 20px; }
.nav { display: flex; gap: 10px; }
</style>
