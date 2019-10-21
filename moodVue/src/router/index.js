import Vue from 'vue'
import Router from 'vue-router'
import Register from "../components/Register";
import Login from "../components/Login";
import Home from "../components/Home"
import PersonIndex from "../components/PersonIndex";
import YourMessage from "../components/YourMessage";
import Follow from "../components/view/Follow";
import OtherIndex from "../components/view/OtherIndex";
import InterMediator from "../components/view/InterMediator";
import Index from "../components/Index";
import UpdateInfo from "../components/view/UpdateInfo";
import Info from "../components/view/personInfo/Info";
import UpdatePassword from "../components/view/personInfo/UpdatePassword";
import UpAvatar from "../components/view/personInfo/UpAvatar";


Vue.use(Router)


export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/login',
      name: 'login',
      component: Login,
    },
    {
      path: '/register',
      name: 'register',
      component: Register,
    },
    {
      path: '/',
      name: 'index',
      component: Index,
      redirect: '/home',
      children:[
        {
          path: '/home',
          name: 'home',
          component: Home,
        },
        {
          path: '/person',
          name: 'person',
          component: PersonIndex,
        },
        {
          path: '/message',
          name: 'message',
          component: YourMessage,
        },
        {
          path: '/follow',
          name: 'follow',
          component: Follow,
        },
      ]
    },

    {
      path: '/otherIndex',
      name: 'otherIndex',
      component: OtherIndex,
    },
    {
      path: '/inter',
      name: 'inter',
      component: InterMediator,
    },
    {
      path: '/update',
      name: 'update',
      component: UpdateInfo,
      redirect:'/info',
      children:[
        {
          path: '/info',
          name: 'info',
          component: Info,
        },
        {
          path: '/password',
          name: 'password',
          component: UpdatePassword,
        },
        {
          path: '/avatar',
          name: 'avatar',
          component: UpAvatar,
        }]
    },
  ]
})
