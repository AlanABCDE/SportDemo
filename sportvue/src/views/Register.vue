<template>
    <div class="wrapper">
      <div class="block" >
        <div style="text-align: center; font-size: 24px;color: #000;"><b>注 册</b></div>
        <el-form-item :model="formData" :rules="rules" ref="userForm">
          <el-form-item prop="username">
            <span class="txt">Username</span>
            <el-input  validate-event:true placeholder="请输入账号" size="medium"   v-model="formData.username"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <span class="txt">Password</span>
            <el-input validate-event:true placeholder="请输入密码" size="medium" show-password v-model="formData.password"></el-input>
          </el-form-item>
          <el-form-item prop="confirmPassword">
            <span class="txt">Confirm</span>
            <el-input validate-event:true placeholder="请确认密码" size="medium"   show-password v-model="formData.confirmPassword"></el-input>
          </el-form-item>
          <el-form-item prop="role">  
          <span class="txt">Role</span>
              <div >
              <el-radio-group v-model="formData.role" size="medium" style="margin-left: 20px;" validate-event:true>
              <el-radio-button prop="User" label="user" />
              <el-radio-button prop="Admin" label="admin"/>
              </el-radio-group>
          </div>
        </el-form-item>
        </el-form-item>
          <el-form-item style="text-align: right" >
            <el-button type="primary" size="small"  autocomplete="off" @click="register()">注册</el-button>
            <el-button type="warning" size="small"  autocomplete="off" @click="goLog()">返回登录</el-button>
          </el-form-item>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  export default {
    data() {
      return {
        formData: {
          username:'',
          password:'',
          role:''
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
          confirmPassword: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
          ],
          role:[
            {required: true}
          ]
        }
      }
    },
    methods: {
      register() {
        console.log(this.formData)
        // this.$refs['userForm'].validate((valid) => {
        //   if (valid) {  // 表单校验合法
        //     if (this.formData.password !== this.formData.confirmPassword) {
        //       this.$message.error("两次输入的密码不一致")
        //       return false
        //     }
        //     axios.post("http://localhost:9090/user/register", this.formData).then(res => {
        //       if(res.data.code === '200') {
        //         this.$message.success("注册成功")
        //       } else {
        //         this.$message.error(res.data.msg)
        //       }
        //     })
        //   }
        // });
        axios.post("http://localhost:9090/user/register", this.formData).then(res => {
              if(res.data.code === '200') {
                this.$message.success("注册成功")
              } else {
                this.$message.error(res.data.msg)
              }
            })
      },
      goLog(){
        this.$router.push('/login')
        
      }
    }
  }
  </script>
  
  <style>
  .wrapper {
    background-image: url('E:\Code\Driving\SportDemo\sportvue\src\assets\index\bg\60.png');
    background-size:cover;
    width: 100%;
    position: absolute;
    height:100%
    }
  .block{
  margin: 200px auto;  width: 350px; height: 300px; padding: 20px; border-radius: 10px;
  background-color: rgba(236,239,247, 0.78);
  border:100px;
}
.txt{
  color: rgb(0, 0, 0);
}
  </style>