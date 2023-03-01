import { createApp } from 'vue'
import './style.css'
import ElementPlus from 'element-plus'
import router from './router'
import axios from 'axios'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import 'element-plus/dist/index.css'
import App from './App.vue'
import locale from 'element-plus/lib/locale/lang/zh-cn';

const app = createApp(App)
app.use(ElementPlus,{ locale })
app.use(router)
// app.use(axios)
app.mount('#app')

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

