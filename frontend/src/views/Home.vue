<template>
  <div class="home">
    <div class="banner">
      <div class="banner-text">
        <h2>🍔 美味送到家</h2>
        <p>精选周边优质餐厅，30分钟极速送达</p>
      </div>
    </div>

    <h3 style="margin:24px 0 16px;">🔥 热门餐厅</h3>
    <el-row :gutter="20">
      <el-col :xs="24" :sm="12" :md="8" v-for="r in restaurants" :key="r.id">
        <el-card @click="$router.push('/restaurant/' + r.id)" class="rest-card" shadow="hover">
          <div class="rest-img" :style="{background: r.gradient}">
            <span class="rest-icon">{{ r.icon }}</span>
          </div>
          <div class="rest-info">
            <h4>{{ r.name }}</h4>
            <p class="rest-desc">{{ r.description }}</p>
            <div class="rest-meta">
              <el-tag type="warning" size="small">⭐ {{ r.score }}</el-tag>
              <span class="sales">月售 {{ r.sales }}单</span>
              <span class="delivery">约{{ r.deliveryTime }}分钟</span>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const restaurants = ref([
  {
    id: 1,
    name: '老王家常菜',
    description: '地道湘菜，辣得过瘾',
    score: 4.8,
    sales: 1286,
    deliveryTime: 25,
    icon: '🌶️',
    gradient: 'linear-gradient(135deg, #ff6b35, #f7931e)'
  },
  {
    id: 2,
    name: '日式拉面馆·一蘭',
    description: '正宗博多豚骨拉面',
    score: 4.9,
    sales: 2156,
    deliveryTime: 20,
    icon: '🍜',
    gradient: 'linear-gradient(135deg, #e74c3c, #c0392b)'
  },
  {
    id: 3,
    name: '意式披萨屋',
    description: '手工现做薄底披萨',
    score: 4.7,
    sales: 892,
    deliveryTime: 30,
    icon: '🍕',
    gradient: 'linear-gradient(135deg, #f39c12, #d68910)'
  },
  {
    id: 4,
    name: '港式茶餐厅',
    description: '丝袜奶茶+菠萝包绝配',
    score: 4.6,
    sales: 756,
    deliveryTime: 22,
    icon: '🧋',
    gradient: 'linear-gradient(135deg, #9b59b6, #8e44ad)'
  },
  {
    id: 5,
    name: '韩式炸鸡啤酒',
    description: '外酥里嫩，多种口味',
    score: 4.8,
    sales: 1589,
    deliveryTime: 18,
    icon: '🍗',
    gradient: 'linear-gradient(135deg, #27ae60, #1e8449)'
  },
  {
    id: 6,
    name: '轻食沙拉工坊',
    description: '低卡健康，健身必备',
    score: 4.5,
    sales: 534,
    deliveryTime: 15,
    icon: '🥗',
    gradient: 'linear-gradient(135deg, #1abc9c, #16a085)'
  }
])
</script>

<style scoped>
.home { padding: 20px; max-width: 1200px; margin: 0 auto; }
.banner {
  background: linear-gradient(135deg, #ff512f, #dd2476);
  border-radius: 12px;
  padding: 40px;
  color: white;
  margin-bottom: 10px;
}
.banner-text h2 { margin: 0 0 8px; font-size: 28px; }
.banner-text p { margin: 0; opacity: 0.9; font-size: 15px; }
.rest-card {
  cursor: pointer;
  margin-bottom: 20px;
  border-radius: 12px;
  overflow: hidden;
}
.rest-card:hover { transform: translateY(-4px); transition: all 0.3s; }
.rest-img {
  height: 140px;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 12px 12px 0 0;
}
.rest-icon { font-size: 48px; }
.rest-info { padding: 14px; }
.rest-info h4 { margin: 0 0 6px; font-size: 16px; }
.rest-desc { font-size: 13px; color: #999; margin: 0 0 10px; }
.rest-meta { display: flex; align-items: center; gap: 10px; }
.sales { color: #666; font-size: 12px; }
.delivery { color: #409eff; font-size: 12px; }
</style>
