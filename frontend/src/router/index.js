import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Restaurant from '../views/Restaurant.vue'
import Orders from '../views/Orders.vue'

const routes = [
    { path: '/', component: Home },
    { path: '/restaurant/:id', component: Restaurant },
    { path: '/orders', component: Orders }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
