<template>
  <div class="restaurant">
    <div class="rest-header" style="background: linear-gradient(135deg, #ff6b35, #f7931e); border-radius:12px; padding:30px; color:white; margin-bottom:24px;">
      <h2 style="margin:0 0 8px;">🌶️ 老王家常菜</h2>
      <p style="margin:0 0 4px; opacity:0.9;">地道湘菜，辣得过瘾 · 湖南长沙口味</p>
      <small>📍 雨花区韶山中路88号 | ☎️ 0731-8888-6666 | ⭐ 4.8分</small>
    </div>

    <h3 style="margin-bottom:16px;">📋 菜单</h3>
    <el-row :gutter="20">
      <el-col :xs="24" :sm="12" :md="8" v-for="m in menus" :key="m.id">
        <el-card class="menu-card" shadow="hover">
          <div class="menu-img" :style="{background: m.gradient}">
            <span style="font-size:40px;">{{ m.icon }}</span>
          </div>
          <div class="menu-info">
            <h4>{{ m.name }}</h4>
            <p>{{ m.description }}</p>
            <el-tag v-if="m.tag" :type="m.tagType || 'danger'" size="small">{{ m.tag }}</el-tag>
          </div>
          <div class="menu-bottom">
            <span class="price">¥{{ m.price }}</span>
            <el-button type="primary" circle size="small" @click="addToCart(m)">
              <span style="font-size:16px;">+</span>
            </el-button>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-divider/>

    <!-- 购物车 -->
    <div class="cart-section">
      <h3>🛒 购物车
        <el-badge :value="cartCount" :max="99" style="margin-left:10px;">
        </el-badge>
      </h3>
      <div v-if="cart.length === 0" class="empty-cart">
        <p>购物车是空的，快去选菜吧~</p>
      </div>
      <div v-else class="cart-items">
        <div v-for="item in cart" :key="item.id" class="cart-item">
          <div class="cart-item-left">
            <b>{{ item.name }}</b>
            <small>¥{{ item.price }}/份</small>
          </div>
          <div class="cart-item-right">
            <el-button size="small" circle @click="decreaseQty(item)">-</el-button>
            <span class="qty-num">{{ item.qty }}</span>
            <el-button size="small" circle @click="increaseQty(item)" type="primary">+</el-button>
            <span class="item-total">¥{{ (item.price * item.qty).toFixed(2) }}</span>
          </div>
        </div>
        <el-divider/>
        <div class="cart-footer">
          <div class="total-text">
            共 <b>{{ cartCount }}</b> 件菜品 &nbsp;&nbsp;
            合计：<b class="total-price">¥{{ total.toFixed(2) }}</b>
          </div>
          <el-button type="danger" size="large" round @click="submitOrder">
            去结算 💰
          </el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { ElMessage } from 'element-plus'

const menus = ref([
  { id: 1, name: '招牌剁椒鱼头', description: '新鲜鱼头配秘制剁椒', price: 68, icon: '🐟', tag: '招牌', tagType: 'danger', gradient: 'linear-gradient(135deg, #e74c3c, #c0392b)' },
  { id: 2, name: '小炒黄牛肉', description: '鲜嫩牛肉配朝天椒', price: 48, icon: '🥩', tag: '热销', tagType: 'warning', gradient: 'linear-gradient(135deg, #f39c12, #d68910)' },
  { id: 3, name: '农家小炒肉', description: '五花肉配青辣椒丝', price: 38, icon: '🍖', gradient: 'linear-gradient(135deg, #27ae60, #1e8449)' },
  { id: 4, name: '干锅花菜', description: '脆嫩花菜配腊肉', price: 32, icon: '🥦', gradient: 'linear-gradient(135deg, #9b59b6, #8e44ad)' },
  { id: 5, name: '皮蛋瘦肉粥', description: '熬制2小时的广式粥', price: 18, icon: '🍲', tag: '新品', tagType: '', gradient: 'linear-gradient(135deg, #f1c40f, #d4ac0d)' },
  { id: 6, name: '手撕包菜', description: '酸辣开胃下饭神器', price: 22, icon: '🥬', gradient: 'linear-gradient(135deg, #1abc9c, #16a085)' },
  { id: 7, name: '酸辣土豆丝', description: '爽脆可口经典家常', price: 18, icon: '🥔', gradient: 'linear-gradient(135deg, #e67e22, '#d35400')' },
  { id: 8, name: '米饭', description: '东北优质大米', price: 2, icon: '🍚', gradient: 'linear-gradient(135deg, #95a5a6, '#7f8c8d')' },
  { id: 9, name: '可乐', description: '冰镇可口可乐', price: 5, icon: '🥤', gradient: 'linear-gradient(135deg, #34495e, '#2c3e50')' }
])

const cart = ref([])

const cartCount = computed(() => cart.value.reduce((sum, item) => sum + item.qty, 0))
const total = computed(() => cart.value.reduce((sum, item) => sum + item.price * item.qty, 0))

function addToCart(menu) {
  const exist = cart.value.find(i => i.id === menu.id)
  if (exist) exist.qty++
  else cart.value.push({ ...menu, qty: 1 })
  ElMessage.success(menu.name + ' 已加入购物车 🎉')
}

function decreaseQty(item) {
  if (item.qty > 1) item.qty--
  else cart.value = cart.value.filter(i => i.id !== item.id)
}

function increaseQty(item) {
  item.qty++
}

function submitOrder() {
  if (cart.value.length === 0) return
  ElMessage.success('✅ 订单提交成功！预计25分钟送达~')
}
</script>

<style scoped>
.restaurant { padding: 20px; max-width: 1200px; margin: 0 auto; }
.menu-card {
  margin-bottom: 20px;
  border-radius: 12px;
  overflow: hidden;
}
.menu-img {
  height: 130px;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 12px 12px 0 0;
}
.menu-info { padding: 14px; }
.menu-info h4 { margin: 0 0 4px; font-size: 15px; }
.menu-info p { font-size: 13px; color: #999; margin: 0 0 6px; }
.menu-bottom {
  padding: 10px 14px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-top: 1px solid #f0f0f0;
}
.price { color: #f56c6c; font-size: 20px; font-weight: bold; }

.cart-section { background:#fafafa; border-radius:12px; padding:20px; }
.empty-cart { text-align:center; padding:40px; color:#ccc; }
.cart-item {
  display:flex; justify-content:space-between; align-items:center;
  padding:12px 0; border-bottom:1px dashed #eee;
}
.cart-item-left b { display:block; font-size:14px; }
.cart-item-left small { color:#999; }
.cart-item-right { display:flex; align-items:center; gap:8px; }
.qty-num { min-width:28px; text-align:center; font-weight:bold; }
.item-total { color:#f56c6c; font-weight:bold; min-width:60px; text-align:right; }
.cart-footer {
  display:flex; justify-content:space-between; align-items:center;
}
.total-text { font-size:15px; }
.total-price { color:#f56c6c; font-size:24px; }
</style>
