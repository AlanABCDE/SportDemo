<template>
    <div class="common-layout">
        <el-container>
            <el-container>
                <div class="head">
                    <el-menu default-active="1" class="menu" mode="horizontal" @select="handleSelect">
                        <el-menu-item index="1">
                            <RouterLink to="userhome">
                                <h1 class="h1">主页</h1>
                            </RouterLink>
                        </el-menu-item>
                        <el-menu-item index="2">
                            <RouterLink to="holdevent">
                                <h1 class="h1">举办赛事</h1>
                            </RouterLink>
                        </el-menu-item>
                        <el-menu-item index="3">
                            <RouterLink to="managemyevent">
                                <h1 class="h1">管理我的赛事</h1>
                            </RouterLink>
                        </el-menu-item>
                        <el-menu-item index="4">
                            <RouterLink to="joinevent">
                                <h1 class="h1">寻找赛事</h1>
                            </RouterLink>
                        </el-menu-item>
                        <el-menu-item index="5">
                            <RouterLink to="team">
                                <h1 class="h1">小队查询</h1>
                            </RouterLink>
                        </el-menu-item>
                        <el-menu-item index="6">
                            <RouterLink to="usermsg">
                                <h1 class="h1">通知</h1>
                            </RouterLink>
                        </el-menu-item>
                        <el-menu-item index="7">
                            <RouterLink to="scoreboard">
                                <h1 class="h1">得分榜</h1>
                            </RouterLink>
                        </el-menu-item>
                        <el-sub-menu index="8">
                            <template #title>
                                <h1 class="h1">个人中心</h1>
                            </template>
                            <el-menu-item index="8-1">
                                <RouterLink to="personalmainpage">
                                    <h1 class="h1">个人主页</h1>
                                </RouterLink>
                            </el-menu-item>
                            <el-menu-item index="8-2">
                                <RouterLink to="personalavatar">
                                    <h1 class="h1">修改头像</h1>
                                </RouterLink>
                            </el-menu-item>
                        </el-sub-menu>
                        <el-menu-item index="9">
                            <RouterLink to="/">
                                <h1 class="h1">关于我</h1>
                            </RouterLink>
                        </el-menu-item>
                        <el-sub-menu>
                            <template #title>
                                <h1 class="h1">有事联系我</h1>
                            </template>
                            <img src="https://raw.githubusercontent.com/AlanABCDE/SportDemo/main/sportvue/src/assets/QRCode.png"
                                class="erweima" />
                        </el-sub-menu>
                        <div class="User-Avatar">
                            <span>欢迎，{{ user.username }}</span>
                            <el-button round @click="logout">登出</el-button>
                        </div>
                    </el-menu>
                </div>
                <el-main class="box"><router-view></router-view></el-main>

            </el-container>
        </el-container>
    </div>
</template>
<script >
import axios from 'axios';
import { ref } from 'vue'
export default {
    name: "Front",
    data() {
        return {
            user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
        }
    },
    created() {

    },
    methods: {
        logout() {
            this.$router.push('/');
            localStorage.removeItem("user")
            //this.$store.commit("logout")
            this.$message.success("退出成功")
        }
    }
}
</script>
<style>.el-aside {
    width: 200px;
}

.common-layout {
    /* background-image:url('https://d34ymitoc1pg7m.cloudfront.net/bf3/backgrounds/bg-bf3-premium-3b9d9943.jpg');
    height: 100%; */
}

.head {
    background-image: url('E:\Code\Driving\SportDemo\sportvue\src\assets\backlogo.png');
    width: 100%;
    position: absolute;
    height: 65px
}

.menu {
    background-color: rgb(236, 241, 236, 0.8);
    color: rgb(0, 0, 0);
    font-weight: 700;
}

.h1 {
    font-size: 20px;
    font-weight: 700;
}

.erweima {
    width: 120px;
    margin: 0 20%;
}

.User-Avatar {
    margin: 0.8% 0 0 25%;
}

.box {
    background-color: rgb(229, 248, 242);
    height: 1080px;
}</style>
