<template>
    <div class="common-layout">
        <el-container>
            <el-aside><el-col :span="12">
                    <el-menu default-active="1" style="width: 200px;" class="el-menu-vertical-demo" 
                    background-color="#b3e19d" 
                    active-color="#409EFF"
                    text-color="#409EFF"
                    >
                        <el-menu-item index="1">
                            <el-icon><House /></el-icon>
                            <span><RouterLink to="/adminfront/adminhome">主页</RouterLink></span>
                        </el-menu-item>
                        <el-menu-item index="2">
                            <el-icon><document /></el-icon>
                            <span><RouterLink to="userlist">用户管理</RouterLink></span>
                        </el-menu-item>
                        <el-menu-item index="3" >
                            <el-icon>
                                <document />
                            </el-icon>
                            <span><RouterLink to="matchresult">成绩管理</RouterLink> </span>
                        </el-menu-item>
                        <el-menu-item index="4">
                            <el-icon>
                                <setting />
                            </el-icon>
                            <span><RouterLink to="manageevent">赛事管理</RouterLink></span>
                        </el-menu-item>
                        <el-menu-item index="4">
                            <el-icon>
                                <setting />
                            </el-icon>
                            <span><RouterLink to="sendmessage">消息管理</RouterLink></span>
                        </el-menu-item>
                    </el-menu>
                </el-col>
            </el-aside>
        <el-container>
            <el-Header class="head">
                <span class="username">欢迎，{{ user.username }}</span>
                <el-button round ><RouterLink to="/">登出</RouterLink></el-button>
            </el-Header>
            <el-Main><router-view></router-view></el-Main>
        </el-container>
        </el-container>
    </div>
</template>
<script >

import axios from 'axios';
import { ref } from 'vue'
export default{
    name: "Front",
    data(){
        return {
            user : localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
        }
    }
}
</script>
<style>
.el-aside {
    width: 200px;
}
a.router-link-active {
    text-decoration: none;
    color: #000;
}
a{
  text-decoration: none;
  color: #000;}
.common-layout{
    /* background-image: url('https://eaassets-a.akamaihd.net/battlelog/bb/bfh/backgrounds/bfhbg-de1c8ba8.png');
    width: 100%;
    height: 100%; */
  }
.el-menu{
    height: 1080px;
    width: 200px;
}
.head{
    height: 75px;
}
.username{
    margin-left: 1400px;
}
</style>
