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
          <el-button @click="dialogVisible = true" text>编辑</el-button>
        </div>
      </template>
      <div>
        <el-form :inline="false" :label-position="labelPosition" :model="formInline" label-width="100px">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="user.username" disabled label-width="100px" />
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="user.password" disabled />
          </el-form-item>
          <el-form-item label=" 性别" prop="">
            <el-input v-model="user.sex" disabled />
          </el-form-item>
          <el-form-item label="角色" prop="role">
            <el-input v-model="user.role" disabled />
          </el-form-item>
          <el-form-item label="电子邮箱" prop="email">
            <el-input v-model="user.email" disabled />
          </el-form-item>
          <el-form-item label="所属班级" prop="classNo">
            <el-input v-model="user.classNo" disabled />
          </el-form-item>
          <el-form-item label="所属队伍" prop="teamId">
            <el-input v-model="user.teamId" disabled />
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
          <el-input v-model="user.password"  />
        </el-col>
      </el-form-item>
      <el-form-item label=" 性别" prop="">
        <el-col :span="8">
          <el-input v-model="user.sex"  />
        </el-col>
      </el-form-item>
      <el-form-item label="角色" prop="role">
        <el-col :span="8">
          <el-input v-model="user.role"  />
        </el-col>
      </el-form-item>
      <el-form-item label="电子邮箱" prop="email">
        <el-col :span="8">
          <el-input v-model="user.email"  />
        </el-col>
      </el-form-item>
      <el-form-item label="所属班级" prop="classNo">
        <el-col :span="8">
          <el-input v-model="user.classNo"  />
        </el-col>
      </el-form-item>
      <el-form-item label="所属队伍" prop="teamId">
        <el-col :span="8">
          <el-input v-model="user.teamId"  />
        </el-col>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button  @click="dialogVisible = false">关 闭</el-button>
      <el-button type="primary" @click="open">提 交</el-button>
    </span>
  </el-dialog>
</template>
<script>
export default {
  name: "UserMsg",
  data() {
    return {
      userInfo:{},
      dialogVisible: false,
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}

    }
  },
  created() {

  },
  methods: {
    goLog() {
      const _this = this;
      _this.$router.push('/login');
    },
    open() {
        this.$confirm('检测到未保存的内容，是否在离开页面前保存修改？', '确认信息', {
          distinguishCancelAndClose: true,
          confirmButtonText: '保存',
          cancelButtonText: '放弃修改'
        })
          .then(() => {
            this.$message({
              type: 'info',
              message: '保存修改'
            });
          })
          .catch(action => {
            this.$message({
              type: 'info',
              message: action === 'cancel'
                ? '放弃保存并离开页面'
                : '停留在当前页面'
            })
          });
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
