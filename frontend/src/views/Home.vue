<template>
  <div class="home">
    <h3>热门餐厅</h3>
    <el-row :gutter="20">
      <el-col :span="6" v-for="r in restaurants" :key="r.id">
        <el-card @click="$router.push('/restaurant/' + r.id)" style="cursor:pointer;margin-bottom:20px;">
          <img :src="r.image" style="width:100%;height:160px;object-fit:cover;" />
          <h4>{{ r.name }}</h4>
          <p>{{ r.description }}</p>
          <div>⭐ {{ r.score }} | 月售 {{ r.sales }}</div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const restaurants = ref([])

onMounted(() => {
  axios.get('/api/restaurant/list').then(res => {
    restaurants.value = res.data.data
  })
})
</script>

<style scoped>
.home { padding: 20px; max-width: 1200px; margin: 0 auto; }
</style>
