<template>
  <h1>用户管理</h1>
  <el-table :data="tableData.slice((page - 1) * limit, page * limit)" style="width: 100%">
    <el-table-column prop="uid" label="编号" width="180" />
    <el-table-column prop="username" label="名字" width="180" />
    <el-table-column prop="password" label="密码" width="180" />
    <el-table-column prop="sex" label="性别" width="180" />
    <el-table-column prop="role" label="角色" width="180" />
    <el-table-column prop="email" label="邮件" />
    <el-table-column prop="classNo" label="班号" />
    <el-table-column prop="teamId" label="所属队伍" />
    <el-table-column fixed="right" label="操作" width="120">
      <template v-slot="scope">
        <el-button link type="primary" size="small" @click="manageUser(scope.row.uid)">管理</el-button>
        <el-button link type="primary" size="small" @click="del(scope.row.uid)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination :current-page="page" :page-size="limit" :page-sizes="[5, 10, 15, 20]" background
    layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
    @current-change="handleCurrentChange" />

    <el-dialog v-model="dialogVisible" title="修改" width="500px">
    <el-form :inline="false" :label-position="labelPosition" model="userInfo" label-width="100px">
      <el-form-item label="用户名" prop="username">
        <el-col :span="16">
          <el-input v-model="userInfo.username" placeholder=user.username />
        </el-col>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-col :span="16">
          <el-input v-model="userInfo.password"  />
        </el-col>
      </el-form-item>
      <el-form-item label=" 性别" prop="sex">
        <el-col :span="16">
          <el-input v-model="userInfo.sex"  />
        </el-col>
      </el-form-item>
      <el-form-item label="角色" prop="role">
        <el-col :span="16">
          <el-select v-model="userInfo.role" placeholder="选择一个身份">
          <el-option label="user" value="user" />
          <el-option label="admin" value="admin" />
        </el-select>
        </el-col>
      </el-form-item>
      <el-form-item label="电子邮箱" prop="email">
        <el-col :span="16">
          <el-input v-model="userInfo.email"  />
        </el-col>
      </el-form-item>
      <el-form-item label="所属班级" prop="classNo">
        <el-col :span="16">
          <el-input v-model="userInfo.classNo"  />
        </el-col>
      </el-form-item>
      <el-form-item label="所属队伍" prop="teamId">
        <el-col :span="16">
          <el-input v-model="userInfo.teamId"  />
        </el-col>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button  @click="dialogVisible = false">关 闭</el-button>
      <el-button type="primary" @click="submit">提 交</el-button>
    </span>
  </el-dialog>
</template>

<script >
import axios from 'axios';
export default {
  data() {
    return {
      dialogVisible : false,
      tableData: [
        {
          uid: '',
          username: '',
          sex: '',
          password: '',
          role: '',
          classNo: '',
          teamId: '',
        },
      ],
      userInfo:{},
      page: 1,
      limit: 5,
      total: 0
    }
  },
  created() {
    axios.get("http://localhost:9090/user/getUser")
      .then(res => {
        console.log(res)
        this.tableData = [...res.data]
        this.total = res.data.length
      })
  },
  methods: {
    load() {
      axios.get("http://localhost:9090/user/getUser")
        .then(res => {
          console.log(res)
          this.tableData = [...res.data]
          this.total = res.data.length
        })
    },
    handleClick() { },
    handleSizeChange(val) {
      this.limit = val
      this.page = 1
    },
    handleCurrentChange(val) {
      this.page = val
    },
    del(uid) {
      console.log(uid)
      axios.delete("http://localhost:9090/user/" + uid).then(res => {
        if (res) {
          this.$message.success("删除成功")
          this.load()
        } else {
          this.$message.error("删除失败")
        }
      })
    },
    manageUser(id){
      this.tableData.forEach((item) => {
        if (item.uid == id) {
          this.userInfo = item
        }
      })
      this.dialogVisible = true
    },
    submit() {
      console.log(this.managerData)
      axios.post("http://localhost:9090/user/updateUserInfo", this.userInfo).then(res => {
        if (res.data.code === '200') {
          this.$message.success("修改成功")
          this.dialogVisible = false
        } else {
          this.$message.error(res.data.msg)
        }
      })
    }

  }
}


</script>
<style>

</style>

