<template>
  <h1>个人中心</h1>
  <div class="block">
    <el-avatar :size="50" :src="circleUrl" />
  </div>
  <div class="card">
    <el-card class="box-card">
      <template #header>
        <div class="card-header">
          <span>我的信息</span>
          <el-button @click="checkEvent" text>已参加的赛事</el-button>
          <el-button @click="check" text>编辑</el-button>
        </div>
      </template>
      <div>
        <el-form model="tableData" :inline="false" :label-position="labelPosition" label-width="100px">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="tableData.username" disabled label-width="100px" />
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="tableData.password" disabled />
          </el-form-item>
          <el-form-item label=" 性别" prop="">
            <el-input v-model="tableData.sex" disabled />
          </el-form-item>
          <el-form-item label="角色" prop="role">
            <el-input v-model="tableData.role" disabled />
          </el-form-item>
          <el-form-item label="电子邮箱" prop="email">
            <el-input v-model="tableData.email" disabled />
          </el-form-item>
          <el-form-item label="所属班级" prop="classNo">
            <el-input v-model="tableData.classNo" disabled />
          </el-form-item>
          <el-form-item label="所属队伍" prop="teamName">
            <el-input v-model="tableData.teamName" disabled />
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
  <el-dialog v-model="dialogVisible" title="修改">
    <el-form :inline="false" :label-position="labelPosition" :model="formInline" label-width="100px">
      <el-form-item label="用户名" prop="username">
        <el-col :span="8">
          <el-input v-model="userInfo.username" placeholder=user.username />
        </el-col>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-col :span="8">
          <el-input v-model="userInfo.password" />
        </el-col>
      </el-form-item>
      <el-form-item label=" 性别" prop="sex">
        <el-col :span="8">
          <el-input v-model="userInfo.sex" />
        </el-col>
      </el-form-item>
      <el-form-item label="角色" prop="role">
        <el-col :span="8">
          <el-input v-model="userInfo.role" disabled />
        </el-col>
      </el-form-item>
      <el-form-item label="电子邮箱" prop="email">
        <el-col :span="8">
          <el-input v-model="userInfo.email" />
        </el-col>
      </el-form-item>
      <el-form-item label="所属班级" prop="classNo">
        <el-col :span="8">
          <el-input v-model="userInfo.classNo" />
        </el-col>
      </el-form-item>
      <el-form-item label="所属队伍" prop="teamName">
        <el-col :span="8">
          <el-select v-model="userInfo.teamName" placeholder="队伍">
            <el-option label="ptsd" value="ptsd" />
            <el-option label="三三说的都对" value="三三说的都对" />
            <el-option label="罕见" value="罕见" />
            <el-option label="队1" value="队1" />
            <el-option label="队2" value="队2" />
            <el-option label="队3" value="队3" />
            <el-option label="队4" value="队4" />
            <el-option label="队5" value="队5" />
            <el-option label="队6" value="队6" />
          </el-select>
        </el-col>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false">关 闭</el-button>
      <el-button type="primary" @click="submit">提 交</el-button>
    </span>
  </el-dialog>
  <el-dialog  v-model="dialogVisible2" title="查询" width="1000px">
    <el-table :data="signData2" >
      <el-table-column prop="eventName" label="eventname"></el-table-column>
      <el-table-column prop="uid" label="uid"></el-table-column>
      <el-table-column prop="username" label="username"></el-table-column>
    </el-table>
  </el-dialog>
</template>
<script>
import axios from 'axios';
export default {
  name: "UserMsg",
  data() {
    return {
      tableData: {
        username: '',
        password: '',
        sex: '',
        role: '',
        email: '',
        classNo: '',
        teamId: '',
        teamName: '',
      },
      userInfo: {
        username: '',
        password: '',
        sex: '',
        role: '',
        email: '',
        classNo: '',
        teamId: '',
        teamName: '',
      },
      signData:{},
      signData2:{},
      dialogVisible: false,
      dialogVisible2: false,
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}

    }
  },
  created() {
    axios.get("http://localhost:9090/user/selUser/" + this.user.username)
      .then(res => {
        console.log(res)
        this.tableData = res.data.data
        console.log(this.tableData)
      })
      axios.get("http://localhost:9090/sign/selUser/" + this.user.username)
      .then(res => {
        console.log(res)
        this.signData = res.data.data
        console.log("-----111------")
        console.log(this.signData)
      })

  },
  methods: {
    load() {
      axios.get("http://localhost:9090/user/selUser/" + this.user.username)
        .then(res => {
          console.log(res)
          this.tableData = res.data
          console.log(this.tableData)
        })
    },
    goLog() {
      const _this = this;
      _this.$router.push('/login');
    },
    check() {
      this.userInfo = this.tableData
      this.dialogVisible = true
    },
    submit() {
      console.log(this.userInfo)
      axios.post("http://localhost:9090/user/updateUserInfo", this.userInfo).then(res => {
        if (res.data.code === '200') {
          this.$message.success("修改成功")
          this.dialogVisible = false
          this.$router.push('/login');
        } else {
          this.$message.error(res.data.msg)
        }
      })
    },
    checkEvent(){
      this.dialogVisible2 = true
      this.signData2 = this.signData
      console.log(this.signData2)
    }
  }
}
</script>
<style>
.el-card__body {
  width: 420px;
}

.card {
  padding: 2em;
  width: 476px;
  position: relative;
  right: -387px;

}

.span {
  width: 100%;
  display: flex;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.box-card {
  width: 1000px;
  height: 500px;
}

.el-form {
  left: 276px;
  position: relative;
}
</style>
