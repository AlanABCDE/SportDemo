<template>
  <div class="wrapper" style="width:2000px">
    <div
      style="margin: 200px auto; background-color: #fff; width: 350px; height: 300px; padding: 20px; border-radius: 10px">
      <div style="margin: 20px 0; text-align: center; font-size: 24px"><b>登 录</b></div>
      <el-form :model="user" :rules="rules" ref="userForm">
        <el-form-item prop="username">
          <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-user" v-model="user.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" show-password
            v-model="user.password"></el-input>
        </el-form-item>
        <el-select v-model="value" class="m-2" placeholder="Select" >
          <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value" />
        </el-select>
        <el-form-item style="margin: 10px 0; text-align: right">
          <el-button type="primary" size="small" autocomplete="off" @click="login">登录</el-button>
          <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/register')">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
</div>
</template>
  
<script>
import { useRouter } from 'vue-router'
import { ref } from 'vue'

const value = ref('')
export default {
  name: "Login",
  data() {
    return {
      user: {},
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ],
      },
      options : [
  {
    value: '1',
    label: 'Admin',
  },
  {
    value: '2',
    label: 'User',
  },
]
    }
  },
  methods: {
    login() {
      // this.$refs['userForm'].validate((valid) => {
      //   if (valid) {  // 表单校验合法
      //     this.request.post("/user/login", this.user).then(res => {
      //       if(res.code === '200') {
      //         localStorage.setItem("user", JSON.stringify(res.data))  // 存储用户信息到浏览器
      //         localStorage.setItem("menus", JSON.stringify(res.data.menus))  // 存储用户信息到浏览器
      //         setRoutes()//动态设置当前用户路由

      //         this.$message.success("登录成功")
      //         if(res.data.role==='admin'){//判断当前用户角色
      //           this.$router.push("/front/Home")
      //         }else{
      //           this.$router.push("/front/UserHome")
      //         }
      //       } else {
      //         this.$message.error(res.msg)
      //       }
      //     })
      //   }
      // });
      const _this = this;
      _this.$router.push('/adminfront/adminhome');
    }
  }
}
</script>
  
<style>
.wrapper {
  height: 100vh;
  width: 1000px;
  background-image: linear-gradient(to bottom right, #53c466, #3F5EFB);
  overflow: hidden;
}
</style>