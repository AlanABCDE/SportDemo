<template>
    <div class="common-layout">
        <el-container>
            <el-container>
                <div class="head">
                    <el-menu default-active="1" class="menu" mode="horizontal" @select="handleSelect">
                        <el-menu-item index="1"><RouterLink to="userhome"><h1 class="h1">HomePage</h1></RouterLink></el-menu-item>
                        <el-menu-item index="2"><RouterLink to="holdevent"><h1 class="h1">Hold an Event</h1></RouterLink></el-menu-item>
                        <el-menu-item index="3"><RouterLink to="managemyevent"><h1 class="h1">Manage my Event</h1></RouterLink></el-menu-item>
                        <el-menu-item index="4"><RouterLink to="joinevent"><h1 class="h1">Join an Event</h1></RouterLink></el-menu-item>
                        <el-menu-item index="7"><RouterLink to="team"><h1 class="h1">Team</h1></RouterLink></el-menu-item>
                        <el-menu-item index="5"><RouterLink to="scoreboard"><h1 class="h1">Scoreboard</h1></RouterLink></el-menu-item>
                        <el-sub-menu index="6">
                                <template #title><h1 class="h1">Personal Center</h1></template>
                                <el-menu-item index="2-1"><RouterLink to="personalmainpage"><h1 class="h1">MainPage</h1></RouterLink></el-menu-item>
                                <el-menu-item index="2-2"><RouterLink to="personalavatar"><h1 class="h1">Change Avatar</h1></RouterLink></el-menu-item>
                        </el-sub-menu>
                        <el-menu-item index="5"><RouterLink to="/"><h1 class="h1">guanyu</h1></RouterLink></el-menu-item>
                        <el-sub-menu >
                            <img src="https://raw.githubusercontent.com/AlanABCDE/SportDemo/main/sportvue/src/assets/QRCode.png" class="erweima"/>
                        </el-sub-menu>
                        <div class="User-Avatar">
                            <el-button round ><RouterLink to="/login">logout</RouterLink></el-button>
                        </div>
                    </el-menu>
                </div>
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
    /* background-image:url('https://d34ymitoc1pg7m.cloudfront.net/bf3/backgrounds/bg-bf3-premium-3b9d9943.jpg');
    height: 100%; */
}
.head{
    background-image: url('E:\Code\Driving\SportDemo\sportvue\src\assets\backlogo.png');
    width: 100%;
    position: absolute;
    height:65px
}
.menu{
    background-color:rgb(236, 241, 236,0.8);
    color: rgb(0, 0, 0);
    font-weight:700;
}
.h1{
    font-size: 20px;
    font-weight: 700;
}
.erweima{
    width: 120px;
    margin: 0 20%;
}
.User-Avatar{
    margin: 0.8% 0 0 30%;
}
</style>
