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
                            <span><RouterLink to="/adminfront/adminhome">HomePage</RouterLink></span>
                        </el-menu-item>
                        <el-menu-item index="2">
                            <el-icon><icon-menu /></el-icon>
                            <span><RouterLink to="userlist">UserList</RouterLink></span>
                        </el-menu-item>
                        <el-menu-item index="3" >
                            <el-icon>
                                <document />
                            </el-icon>
                            <span><RouterLink to="matchresult">MatchResult</RouterLink> </span>
                        </el-menu-item>
                        <el-menu-item index="4">
                            <el-icon>
                                <setting />
                            </el-icon>
                            <span><RouterLink to="manageevent">Manage Event</RouterLink></span>
                        </el-menu-item>
                        <el-menu-item index="4">
                            <el-icon>
                                <setting />
                            </el-icon>
                            <span><RouterLink to="sendmessage">Send Message</RouterLink></span>
                        </el-menu-item>
                    </el-menu>
                </el-col>
            </el-aside>
        <el-container>
            <el-Header class="head">
                <el-button round ><RouterLink to="/login">logout</RouterLink></el-button>
            </el-Header>
            <el-Main><router-view></router-view></el-Main>
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
a.router-link-active {
    text-decoration: none;
    color: #000;
}
a{
  text-decoration: none;
  color: #000;}
.common-layout{
    background-image: url('https://eaassets-a.akamaihd.net/battlelog/bb/bfh/backgrounds/bfhbg-de1c8ba8.png');
    width: 100%;
    height: 100%;
  }
.el-menu{
    height: 1080px;
    width: 200px;
}
.head{
    height: 15px;
}
</style>
