import Vue from 'vue'
import Vuex from 'vuex'

//安装插件
Vue.use(Vuex)


const store = new Vuex.Store({
  state:{
   user:{}
  },
  //  使用它来修改数据(类似于methods)
  mutations:{
    saveLoginUser(state,payload){
      state.user = payload.user
    },
	
	
  },

//发起异步请求
 actions:{

  },
  // 类似于computed(计算属性，对现有的状态进行计算得到新的数据-------派生 )
  getters:{
	
  }
})

//3.导出store对象
export default store
