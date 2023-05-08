import router, {resetRouter} from '@/router'
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
        currentPathName: ''
    },
    mutations: {
        setPath (state) {
            state.currentPathName = localStorage.getItem("currentPathName")
        },
        logout() {
            // 清空缓存
            localStorage.removeItem("user")
            router.push("/")
            // 重置路由
            resetRouter()
        }
    }
})

export default store
//-------------------------------------//
// import {createStore} from 'vuex'

// interface State {
//     count: number,
// }

// // 创建 store 实例
// const store = createStore<State>({
//     // store 的初始状态
//     state() {
//         // 初始状态
//         return {
//             count: 0,
//         }
//     },
//     // 定义了同步方法，通过调用 commit 方法来触发
//     mutations: {
//         // 同步方法
//         increment(state) {
//             state.count++
//         },
//         decrement(state) {
//             state.count--
//         },
//         logout(){
//             localStorage.removeItem("user")
            
//         }
        
//     },
//     // 定义了异步方法，通过调用 dispatch 方法来触发
//     actions: {
//         // 异步方法
//         async incrementAsync(context) {
//             await new Promise(resolve => setTimeout(resolve, 1000))
//             context.commit('increment')
//         }
//     },
//     // 定义了计算属性，可以用于派生出其他状态
//     getters: {
//         // 计算属性
//         doubleCount(state) {
//             return state.count * 2
//         }
//     },
//     // 定义了模块，可以将 store 拆分成多个模块
//     modules: {
//         // 模块
//     }
// })

// export default store
