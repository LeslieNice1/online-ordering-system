<template>
  <div class="orders">
    <h3>我的订单</h3>
    <div v-if="orders.length === 0">暂无订单</div>
    <el-card v-for="o in orders" :key="o.id" style="margin-bottom:15px;">
      <div><b>订单号：</b>{{ o.orderNo }}</div>
      <div><b>金额：</b>¥{{ o.totalAmount }}</div>
      <div><b>状态：</b>{{ statusText(o.status) }}</div>
      <div><b>地址：</b>{{ o.address }}</div>
      <div><b>电话：</b>{{ o.phone }}</div>
      <div><small>{{ o.createTime }}</small></div>
    </el-card>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const orders = ref([])

onMounted(() => {
  // 简化：默认查 userId=1 的订单（实际应先登录获取userId）
  axios.get('/api/order/user/1').then(res => {
    orders.value = res.data.data
  })
})

function statusText(s) {
  return ['待支付', '已支付', '配送中', '已完成', '已取消'][s] || '未知'
}
</script>

<style scoped>
.orders { padding: 20px; max-width: 800px; margin: 0 auto; }
</style>
