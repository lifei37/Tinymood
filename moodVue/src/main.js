// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueResource from 'vue-resource'
import store from './store/store'

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueResource)


// 导航守卫
// 参数1 : to 目标路由对象
// 参数2 : from 来源路由对象
// 参数3 : next() 下一步
router.beforeEach((to, from, next) => {
  console.log(to.path,'============')
  if (to.path=='/home' || to.path=='/login' || to.path=='/register') {
    next()
  }else {
    if(sessionStorage.getItem('userName')){
      next();
    }else {
      next({
        path: '/login',
        query: {
          redirect: to.fullPath    // 将跳转的路由path作为参数，登录成功后跳转到该路由
        }
      })
    }}});

export let bus = new Vue();
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  // components: { App },
  // template: '<App/>',
  render: h => h(App)
})
