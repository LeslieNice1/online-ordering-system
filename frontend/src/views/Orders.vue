<template>
  <div class="orders">
    <h3 style="margin-bottom:20px;">📋 我的订单</h3>
    <el-tabs v-model="activeTab">
      <el-tab-pane label="全部" name="all"></el-tab-pane>
      <el-tab-pane label="待支付" name="0"></el-tab-pane>
      <el-tab-pane label="配送中" name="2"></el-tab-pane>
      <el-tab-pane label="已完成" name="3"></el-tab-pane>
    </el-tabs>

    <div v-for="o in orders" :key="o.id" class="order-card">
      <div class="order-header">
        <b>订单号：{{ o.orderNo }}</b>
        <el-tag :type="statusType(o.status)" size="small">{{ statusText(o.status) }}</el-tag>
      </div>
      <div class="order-items">
        <span v-for="(item, idx) in o.items" :key="idx" class="order-item">
          {{ item.name }} x{{ item.qty }}
        </span>
      </div>
      <div class="order-footer">
        <span>📍 {{ o.address }}</span>
        <span class="order-total">¥{{ o.totalAmount.toFixed(2) }}</span>
      </div>
      <small class="order-time">{{ o.createTime }}</small>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const activeTab = ref('all')

const orders = ref([
  {
    id: 1,
    orderNo: 'OD202406270001',
    status: 3, // 已完成
    totalAmount: 158.00,
    address: '岳麓区大学城天马路1号',
    createTime: '2024-06-27 12:30',
    items: [
      { name: '招牌剁椒鱼头', qty: 1 },
      { name: '小炒黄牛肉', qty: 2 },
      { name: '米饭', qty: 3 }
    ]
  },
  {
    id: 2,
    orderNo: 'OD202406270002',
    status: 2, // 配送中
    totalAmount: 86.00,
    address: '雨花区韶山中路88号',
    createTime: '2024-06-27 18:15',
    items: [
      { name: '农家小炒肉', qty: 1 },
      { name: '干锅花菜', qty: 1 },
      { name: '酸辣土豆丝', qty: 1 },
      { name: '可乐', qty: 2 }
    ]
  },
  {
    id: 3,
    orderNo: 'OD202406270003',
    status: 0, // 待支付
    totalAmount: 42.00,
    address: '开福区芙蓉北路56号',
    createTime: '2024-06-27 19:45',
    items: [
      { name: '皮蛋瘦肉粥', qty: 2 },
      { name: '手撕包菜', qty: 1 }
    ]
  }
])

function statusText(s) {
  return ['待支付', '已支付', '配送中', '已完成', '已取消'][s] || '未知'
}
function statusType(s) {
  return ['', 'info', 'warning', 'success', 'danger'][s] || 'info'
}
</script>

<style scoped>
.orders { padding: 20px; max-width: 800px; margin: 0 auto; }
.order-card {
  border: 1px solid #e8e8e8;
  border-radius: 10px;
  padding: 18px;
  margin-bottom: 16px;
  background: #fff;
}
.order-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 12px;
}
.order-items {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
  padding: 10px 0;
  border-top: 1px dashed #eee;
  border-bottom: 1px dashed #eee;
}
.order-item {
  background: #f5f7fa;
  padding: 3px 10px;
  border-radius: 15px;
  font-size: 13px;
  color: #606266;
}
.order-footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-top: 10px;
}
.order-total {
  color: #f56c6c;
  font-size: 20px;
  font-weight: bold;
}
.order-time {
  display: block;
  text-align: right;
  color: #bbb;
  margin-top: 6px;
}
</style>
