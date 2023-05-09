<template>
    <div class="common-layout">
        <el-container>
            <el-container>
                <div class="head">
                    <el-menu default-active="1" class="menu" mode="horizontal" @select="handleSelect">
                        <el-menu-item index="1">
                            <RouterLink to="guesthome">
                                <h1 class="h1">主页</h1>
                            </RouterLink>
                        </el-menu-item>
                        <el-tooltip class="box-item" effect="dark" content="登录/注册 后可访问" placement="bottom">
                            <el-menu-item index="2" disabled>
                                <RouterLink to="holdevent">
                                    <h1 class="h1">举办赛事</h1>
                                </RouterLink>
                            </el-menu-item>
                        </el-tooltip>
                        <el-tooltip class="box-item" effect="dark" content="登录/注册 后可访问" placement="bottom">
                            <el-menu-item index="3" disabled>
                                <RouterLink to="managemyevent">
                                    <h1 class="h1">管理我的赛事</h1>
                                </RouterLink>
                            </el-menu-item>
                        </el-tooltip>
                        <el-menu-item index="4">
                            <RouterLink to="joinevent">
                                <h1 class="h1">寻找赛事</h1>
                            </RouterLink>
                        </el-menu-item>
                        <el-tooltip class="box-item" effect="dark" content="登录/注册 后可访问" placement="bottom">
                            <el-menu-item index="5" disabled>
                                <RouterLink to="team">
                                    <h1 class="h1">小队查询</h1>
                                </RouterLink>
                            </el-menu-item>
                        </el-tooltip>
                        <el-tooltip class="box-item" effect="dark" content="登录/注册 后可访问" placement="bottom">
                            <el-menu-item index="6" disabled>
                                <RouterLink to="usermsg">
                                    <h1 class="h1">通知</h1>
                                </RouterLink>
                            </el-menu-item>
                        </el-tooltip>
                        <el-menu-item index="7">
                            <RouterLink to="scoreboard">
                                <h1 class="h1">得分榜</h1>
                            </RouterLink>
                        </el-menu-item>
                        <el-tooltip class="box-item" effect="dark" content="登录/注册 后可访问" placement="bottom">
                            <el-sub-menu index="8" disabled>
                                <template #title>
                                    <h1 class="h1">个人中心</h1>
                                </template>
                                <el-menu-item index="8-1" disabled>
                                    <RouterLink to="personalmainpage">
                                        <h1 class="h1">个人主页</h1>
                                    </RouterLink>
                                </el-menu-item>
                                <el-menu-item index="8-2" disabled>
                                    <RouterLink to="personalavatar">
                                        <h1 class="h1">修改头像</h1>
                                    </RouterLink>
                                </el-menu-item>
                            </el-sub-menu>
                        </el-tooltip>
                        <el-menu-item index="9">
                            <RouterLink to="/">
                                <h1 class="h1">门户</h1>
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
                            <span>你好，访客。</span>
                            <el-button round @click="log">注册/登录</el-button>
                        </div>
                    </el-menu>
                </div>
                <el-main class="box"><router-view></router-view></el-main>

            </el-container>
        </el-container>
    </div>
</template>
<script >
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
        log() {
            this.$router.push('/login');
        }
    }
}
</script>
<style>
.el-aside {
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
}
</style>
