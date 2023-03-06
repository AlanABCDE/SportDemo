<template>
  <div  class="wrapper" >
    <div
      style="margin: 200px auto; background-color: #fff; width: 350px; height: 300px; padding: 20px; border-radius: 10px">
      <div style="margin: 20px 0; text-align: center; font-size: 24px"><b>登 录</b></div>
      <el-form :model="formData" :rules="rules" ref="userForm">
      <el-form-item prop="username">
        <span>Username</span><el-input v-model="formData.username" size="medium"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <span>Password</span><el-input v-model="formData.password" size="medium"></el-input>
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
        // role: ''
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
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
            if (res.code === '200') {
              localStorage.setItem("user", JSON.stringify(res.data))  // 存储用户信息到浏览器
              // setRoutes()//动态设置当前用户路由

              this.$message.success("登录成功")
              if (res.data.role === 'user') {
                const _this = this;
                _this.$router.push('/UserFront/UserHome');
              } else {
                this.$router.push('/AdminFront/AdminHome')
              }
            } else {
              this.$message.error('sb')
            }
          })
        }
      });
      // console.log(this.form)
      // this.$message.success("success")
      // axios.post("http://localhost:9090/user/login",this.form)
      // .then(res => {
      //   console.log(res)
      //   if (res.data.role==='user') {
      //     const _this = this;
      //     _this.$router.push('/UserFront/UserHome');
      //   }else if(res.data.role==='admin'){
      //     this.$router.push('/AdminFront/AdminHome')
      //   }else{
      //     this.$router.push('/Login')
      //   }
      // })
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
  /* width: 1903px;
  height: 1500px;
  margin: 0px;
  background-image: linear-gradient(to bottom right, #53c466, #3F5EFB);
  overflow: hidden; */
  background-image: url('https://pixivel.moe/f5e5adb7-ddfb-4afa-ab2b-af91b4797d74');
    width: 100%;
    position: absolute;
    height:65px
}
</style>