import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import store from './store'
axios.defaults.withCredentials=true
Vue.config.productionTip = false
Vue.prototype.$http=axios
new Vue({
  render: h => h(App),
  router,
  store,
}).$mount('#app')
