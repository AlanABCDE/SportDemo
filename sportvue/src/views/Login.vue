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
        // username: '',
        // password: '',
        // role: ''
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
      const _this=this
      this.$refs['userForm'].validate((valid) => {

        if (valid) {  // 表单校验合法
          axios.post("http://localhost:9090/user/login", this.formData).then(res => {
            _this.formData=res.data
            console.log(_this.formData)
            //console.log(res.data.data.role)
            console.log(res.data.data)

            if (res.data.code === '200') {
               localStorage.setItem("user", JSON.stringify(res.data.data))// 存储用户信息到浏览器
              // setRoutes()//动态设置当前用户路由
              console.log(JSON.stringify(res.data.data))
                this.tableData=res.data.data
                console.log("-------------------------------")
                console.log(JSON.stringify(this.tableData.data))
              if (res.data.data.role == 'user'  ) {
                this.$router.push('/UserFront/UserHome');
                this.$message.success("登录成功")
              } else if(res.data.data.role == 'admin'){
                this.$router.push('/AdminFront/AdminHome')
                this.$message.success("登录成功")
              } 
            } else {
              this.$message.error(res.data.msg)
              //console.log(res.data.msg)
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
  background-image: url('https://cdn4.eyeem.com/thumb/b62716d62756471677a3a3a373236323133333031323335313d293531366161693834613361603437366460383136673837303433656037323333336164336164646a3a3a3/1100/1100');
 background-size:100% 100%;
    width: 100%;
    position: absolute;
    height:100%
}
.block{
  margin: 200px auto;  width: 350px; height: 300px; padding: 20px; border-radius: 10px;
  background-color: rgba(0, 0, 0, 0.5);
  border:100px;
}
.txt{
  color: rgb(211, 211, 211);
}
</style>