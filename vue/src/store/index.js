import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user:{
      name:null,
      password:null
    },
    loginstate:true
  },
  mutations: {
    pushUsers(state,payload){
      state.user.name = payload.name;
      state.user.password = payload.author;
    },
    changloginstate(state,payload){
      state.loginstate = payload;
    }
  },
  actions: {
  },
  modules: {
  }
})
