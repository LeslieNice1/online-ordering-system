<template>
  <div class="restaurant">
    <div v-if="restaurant">
      <h2>{{ restaurant.name }}</h2>
      <p>{{ restaurant.description }}</p>
      <p>地址：{{ restaurant.address }} | 电话：{{ restaurant.phone }}</p>
    </div>

    <el-divider/>

    <h3>菜单</h3>
    <el-row :gutter="20">
      <el-col :span="8" v-for="m in menus" :key="m.id">
        <el-card style="margin-bottom:20px;">
          <img :src="m.image" style="width:100%;height:140px;object-fit:cover;" />
          <h4>{{ m.name }}</h4>
          <p>{{ m.description }}</p>
          <div style="display:flex;justify-content:space-between;align-items:center;">
            <span style="color:#f56c6c;font-size:18px;">¥{{ m.price }}</span>
            <el-button type="primary" size="small" @click="addToCart(m)">加入购物车</el-button>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-divider/>
    <h3>购物车</h3>
    <div v-if="cart.length === 0">购物车为空</div>
    <div v-else>
      <div v-for="item in cart" :key="item.id" style="display:flex;justify-content:space-between;padding:10px 0;border-bottom:1px solid #eee;">
        <span>{{ item.name }} x {{ item.qty }}</span>
        <span>¥{{ (item.price * item.qty).toFixed(2) }}</span>
      </div>
      <div style="margin-top:20px;">
        <b>合计：¥{{ total.toFixed(2) }}</b>
        <el-button type="danger" style="margin-left:20px;" @click="submitOrder">提交订单</el-button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'
import { ElMessage } from 'element-plus'

const route = useRoute()
const router = useRouter()

const restaurant = ref(null)
const menus = ref([])
const cart = ref([])

const total = computed(() => cart.value.reduce((sum, item) => sum + item.price * item.qty, 0))

onMounted(() => {
  const id = route.params.id
  axios.get('/api/restaurant/' + id).then(res => restaurant.value = res.data.data)
  axios.get('/api/menu/list?restaurantId=' + id).then(res => menus.value = res.data.data)
})

function addToCart(menu) {
  const exist = cart.value.find(i => i.id === menu.id)
  if (exist) exist.qty++
  else cart.value.push({ ...menu, qty: 1 })
  ElMessage.success('已加入购物车')
}

function submitOrder() {
  if (cart.value.length === 0) return
  const address = prompt('请输入配送地址：')
  if (!address) return
  const phone = prompt('请输入联系电话：')
  if (!phone) return
  // 简化：直接创建订单（实际应先登录）
  axios.post('/api/order/create', null, {
    params: { userId: 1, restaurantId: route.params.id, totalAmount: total.value, address, phone }
  }).then(res => {
    ElMessage.success('订单创建成功！订单号：' + res.data.data)
    cart.value = []
    router.push('/orders')
  })
}
</script>

<style scoped>
.restaurant { padding: 20px; max-width: 1200px; margin: 0 auto; }
</style>
