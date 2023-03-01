<template>
<div class="wrapper" >
  <div style="margin: 200px auto; background-color: #fff; width: 350px; height: 300px; padding: 20px; border-radius: 10px">
    <div style="margin: 20px 0; text-align: center; font-size: 24px"><b>登 录</b></div>
    <el-form-item prop="username">
          <span>Username</span><el-input size="medium"  ></el-input>
        </el-form-item>
        <el-form-item prop="username">
          <span>Password</span><el-input size="medium"  ></el-input>
        </el-form-item>
         <div class="my-4 flex items-center text-sm" >
          <span>role</span>
    <el-radio-group v-model="radio3" class="ml-4">
      
      <el-radio label="1" size="small">admin</el-radio>
      <el-radio label="2" size="small">user</el-radio>
    </el-radio-group>
  </div>
  <el-button type="primary" @Click="Login">登录</el-button><el-button type="warning" @Click="register">注册</el-button>
  </div>
</div>
</template>
  
<script lang="ts" setup>
import {useRouter} from 'vue-router'
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const value = ref('')
const radio3 = ref('1')
const router=useRouter()
const data = reactive({
      aboutExeVisible: false,
})
const Login = () => {
    router.push('/adminfront/adminhome')
    data.aboutExeVisible = true
}
const register = () => {
    router.push('/register')
    data.aboutExeVisible = true
}
</script>
  
<style>
.wrapper {
  width:1903px;
  height:1500px;
  margin:0px;
  background-image: linear-gradient(to bottom right, #53c466, #3F5EFB);
  overflow: hidden;
}
</style>