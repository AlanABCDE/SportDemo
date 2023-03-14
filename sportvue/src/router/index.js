import { createRouter, createWebHistory, createWebHashHistory } from 'vue-router'
import OutHome from '../views/OutHome.vue'
const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'OutHome',
            component:() => OutHome
        },
        {
            path: '/login',
            name: 'login',
            component: () => import(`../views/Login.vue`)
        },
        {
            path: '/test',
            name: 'test',
            component: () => import(`../views/test.vue`)
        },
        {
            path: '/register',
            name: 'register',
            component: () => import(`../views/Register.vue`)
        },
        {
            path: '/adminfront',
            name: 'adminfront',
            component: () => import(`../views/AdminFront/AdminFront.vue`),
            children: [
                { path: 'front', name: 'front',component: () => import('../views/AdminFront/AdminFront.vue')},
                { path: 'adminhome', name: 'AdminHome',component: () => import('../views/AdminFront/AdminHome.vue')},
                { path: 'userlist', name: 'UserList',component: () => import('../views/AdminFront/UserList.vue')},
                { path: 'matchresult', name: 'MatchResult',component: () => import('../views/AdminFront/MatchResult.vue')},
                { path: 'manageevent', name: 'ManageEvent',component: () => import('../views/AdminFront/ManageEvent.vue')},
                { path: 'sendmessage', name: 'SendMessage',component: () => import('../views/AdminFront/SendMessage.vue')},
            ]
        },
        {
            path: '/userfront',
            name: 'userfront',
            component: () => import(`../views/UserFront/Front.vue`),
            children: [
                { path: 'userhome', name: 'UserHome',component: () => import('../views/UserFront/UserHome.vue')},
                { path: 'holdevent', name: 'HoldEvent',component: () => import('../views/UserFront/HoldEvent.vue')},
                { path: 'joinevent', name: 'JoinEvent',component: () => import('../views/UserFront/JoinEvent.vue')},
                { path: 'managemyevent', name: 'ManageMyEvent',component: () => import('../views/UserFront/ManageMyEvent.vue')},
                { path: 'personalavatar', name: 'PersonalAvatar',component: () => import('../views/UserFront/PersonalAvatar.vue')},
                { path: 'personalddit', name: 'PersonalEdit',component: () => import('../views/UserFront/PersonalEdit.vue')},
                { path: 'personalmainpage', name: 'PersonalMainPage',component: () => import('../views/UserFront/PersonalMainPage.vue')},
                { path: 'scoreboard', name: 'ScoreBoard',component: () => import('../views/UserFront/ScoreBoard.vue')},
            ]
        }
    ]
})


export default router
