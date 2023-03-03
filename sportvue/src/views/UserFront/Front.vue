<template>
    <div class="common-layout">
        <el-container>
            <el-container>
                <el-Header class="head">
                    <el-menu default-active="1" class="menu" mode="horizontal" @select="handleSelect">
                        <el-menu-item index="1"><RouterLink to="userhome">HomePage</RouterLink></el-menu-item>
                        <el-menu-item index="2"><RouterLink to="holdevent">Hold an Event</RouterLink></el-menu-item>
                        <el-menu-item index="3"><RouterLink to="managemyevent">Manage my Event</RouterLink></el-menu-item>
                        <el-menu-item index="4"><RouterLink to="joinevent">Join an Event</RouterLink></el-menu-item>
                        <el-menu-item index="5"><RouterLink to="scoreboard">Scoreboard</RouterLink></el-menu-item>
                        <el-sub-menu index="6">
                                <template #title>Personal Center</template>
                                <el-menu-item index="2-1"><RouterLink to="personalmainpage">MainPage</RouterLink></el-menu-item>
                                <el-menu-item index="2-2"><RouterLink to="personalavatar">Change Avatar</RouterLink></el-menu-item>
                        </el-sub-menu>
                        <el-menu-item index="5"><RouterLink to="/">guanyu</RouterLink></el-menu-item>
                        <el-sub-menu index="5">
                            <el-menu-item><img url="https://gitee.com/alanabcde/SportDemo/raw/main/sportvue/src/assets/QRCode.png" /></el-menu-item>
                        </el-sub-menu>
                        <el-button round ><RouterLink to="/login">logout</RouterLink></el-button>
                    </el-menu>
                </el-Header>
                <el-main><router-view></router-view></el-main>
                
            </el-container>
        </el-container>
    </div>
</template>
<script lang="ts" setup>
import { createApp, ref } from 'vue'
import {
    Document,
    Menu as IconMenu,
    Location,
    Setting,
} from '@element-plus/icons-vue'

const activeIndex = ref('1')
const activeIndex2 = ref('1')
const handleSelect = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}
</script>
<style>
.el-aside {
    width: 200px;
}
.common-layout{
    background-image:url('');
    height: 100%;
}
.head{
    background-image: url('E:\Code\Driving\SportDemo\sportvue\src\assets\backlogo.png');
}
.menu{
    background-color:rgb(236, 241, 236,0.3);
    color: rgb(0, 0, 0);
    font-weight:250;
}
</style>
