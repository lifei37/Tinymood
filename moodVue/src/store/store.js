import Vue from 'vue'
import Vuex from 'vuex'


Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {
      userName: '',
      userId: 0,
      heUserId: 0
    }
  },
  mutations: {
    userStatus(state, user){
      if(user){
        state.userName = user.userName;
        state.userId = user.id;
      }
    },
    heUserStatus(state, heUserId){
      state.heUserId = heUserId;
    }
  },
  actions: {
    setUser({commit}, user){
        commit('userStatus', user)
    },
    setHeUser({commit}, heUserId){
      commit('userStatus', heUserId)
    }
  }
})
