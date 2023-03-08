<template>
  <div  class="wrapper" >
    <div class="block">
      <div style="margin: 20px 0; text-align: center; font-size: 24px;color: #000;"><b>登 录</b></div>
      <el-form :model="formData" :rules="rules" ref="userForm">
      <el-form-item prop="username">
        <span class="txt">Username</span><el-input v-model="formData.username" size="medium" placeholder="请输入账号"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <span class="txt">Password</span><el-input v-model="formData.password" size="medium" show-password placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-button type="primary" @Click="Login">登录</el-button><el-button type="warning" @Click="register">注册</el-button>
      </el-form>
    </div>
  </div>
</template>
  
<script>
import axios from 'axios';
import { ref } from 'vue'
const dialogVisible = ref(false)
export default {
  data() {
    return {
      formData: {
        username: '',
        password: '',
        role: ''
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 1, message: '长度大于 1 字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 1,  message: '长度大于 1 字符', trigger: 'blur' }
        ],
      }
    }
  },
  created() {

  },

  methods: {
    Login() {
      console.log(this.formData)
      this.$refs['userForm'].validate((valid) => {
        if (valid) {  // 表单校验合法
          axios.post("http://localhost:9090/user/login", this.formData).then(res => {
            console.log(res)
            console.log(res.data.role)
            if (res.data.code === '200') {
              console.log(res.data.role)
               localStorage.setItem("user", JSON.stringify(res.data))// 存储用户信息到浏览器
              // setRoutes()//动态设置当前用户路由
              console.log(res.data.role)
              this.$message.success("登录成功")
              console.log(res.data.role)
              if (res.data.role === 'user'  ) {
                this.$router.push('/UserFront/UserHome');
              } else {
                this.$router.push('/AdminFront/AdminHome',
                console.log(res.data.role))
              }
            } else {
              this.$message.error(res.data.msg)
            }
          })
        }
      });
    },

    register() {
      const _this = this;
      _this.$router.push('/Register');
    }
  }
}
</script>
  
<style>
.wrapper {
  background-image: url('E:\Code\Driving\SportDemo\sportvue\src\assets\index\002.JPG');
  background-size:100% 100%;
    width: 100%;
    position: absolute;
    height:100%
}
.block{
  margin: 200px auto;  width: 350px; height: 300px; padding: 20px; border-radius: 10px;
  background-color: rgb(92,93,73,0.5);
  border:100px;
}
.txt{
  color: rgb(211, 211, 211);
}
</style>