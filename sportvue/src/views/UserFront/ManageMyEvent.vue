<template>
  <div class="body">
    <h1>管理我的赛事</h1>
    <span class="s1">你好 {{ user.username }} , 以下是你举办的赛事</span>
    <el-table :data="tableData.slice((page - 1) * limit, page * limit)" style="width: 100%;height: 300px;">
      <el-table-column prop="eventId" label="比赛编号" width="180" />
      <el-table-column prop="eventName" label="比赛名称" width="180" />
      <el-table-column prop="eventDis" label="比赛描述" width="180" />
      <el-table-column label="操作">
        <template v-slot="scope">
          <el-button type="success" @click="managerevent(scope.row.eventId)">管理<i class="el-icon-edit"></i></el-button>
          <el-button type="danger" @click="deleteEvent(scope.row.eventId)">删了</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination :current-page="page" :page-size="limit" :page-sizes="[5, 10, 15, 20]" background
    layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
    @current-change="handleCurrentChange" />
  </div>
  <el-dialog v-model="dialogVisible1" title="修改赛事" width="800px">
    <el-form model="managerData" label-width="100px" class="form" :size="formSize">
      <el-form-item label="赛事id" prop="eventId">
        <el-input v-model="managerData.eventId" placeholder=managerData.eventId disabled />
      </el-form-item>
      <el-form-item label="赛事名称" prop="eventName">
        <el-input v-model="managerData.eventName" placeholder=managerData.eventName />
      </el-form-item>
      <el-form-item label="比赛场地" prop="eventZone">
        <el-select v-model="managerData.eventZone" placeholder="选择一个场地">
          <el-option label="篮球场1" value="篮球场1" />
          <el-option label="篮球场2" value="篮球场2" />
          <el-option label="篮球场3" value="篮球场3" />
          <el-option label="足球场1" value="足球场1" />
          <el-option label="足球场2" value="足球场2" />
          <el-option label="网球场1" value="网球场1" />
          <el-option label="网球场2" value="网球场2" />
          <el-option label="网球场3" value="网球场3" />
        </el-select>
      </el-form-item>
      <el-form-item label="比赛时间">
        <el-col :span="11">
          <el-form-item prop="eventDate">
            <el-date-picker v-model="managerData.eventDate" type="date" label="Pick a date" placeholder="选个日期"
              style="width: 100%" />
          </el-form-item>
        </el-col>
        <el-col class="text-center" :span="2">
          <span class="text-gray-500">-</span>
        </el-col>
        <el-col :span="11">
          <el-form-item prop="eventTime">
            <el-time-picker value-format="HH:mm:ss" v-model="managerData.eventTime" label="Pick a time" placeholder="选个时间"
              style="width: 100%" />
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="比赛人数" prop="eventPlayernumber">
        <el-input style="width: 100px;" v-model="managerData.eventPlayernumber" />
      </el-form-item>
      <el-form-item label="承办人姓名" prop="eventHolder">
        <el-input v-model="managerData.eventHolder" />
      </el-form-item>
      <el-form-item label="赛事描述" prop="eventDis">
        <el-input v-model="managerData.eventDis" type="textarea" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">
          提交
        </el-button>
        <el-button @click="dialogVisible1 = false">取消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>
<script>

import axios from 'axios';
export default{
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      tableData: [],
      managerData: {},
      eventHolder: '',
      dialogVisible1: false,
      page: 1,
      limit: 5,
      total: 0
    }
  },
  created() {
    axios.get("http://localhost:9090/event/selEvent/" + this.user.username, {
      })
        .then(res => {
          console.log(JSON.stringify(res.data.data))
          this.tableData = res.data.data
          this.total = res.data.data.length
          console.log("-------------------------------")
          console.log(JSON.stringify(this.tableData.data))
        })
  },
  methods: {
    load() {
      axios.get("http://localhost:9090/event/selEvent/" + this.eventHolder, {
      })
        .then(res => {
          console.log(JSON.stringify(res.data.data))
          this.tableData = res.data.data
          this.total = res.data.data.length
          console.log("-------------------------------")
          console.log(JSON.stringify(this.tableData.data))
        })
    },
    deleteEvent(eventId) {
      console.log(eventId)
      axios.delete("http://localhost:9090/event/" + eventId).then(res => {
        if (res) {
          this.$message.success("删除成功")
          this.load()
        } else {
          this.$message.error("删除失败")
        }
      })
    },
    managerevent(id) {
      this.tableData.forEach((item) => {
        if (item.eventId == id) {
          this.managerData = item
        }
      })
      this.dialogVisible1 = true
    },
    submit() {
      console.log(this.managerData)
      axios.post("http://localhost:9090/event/holdEvent", this.managerData).then(res => {
        if (res.data.code === '200') {
          this.$message.success("修改成功")
          this.dialogVisible1 = false
        } else {
          this.$message.error(res.data.msg)
        }
      })
    }
  }
}

</script>
<style>
.body {
  width: 1000px;
  margin: 0px auto;
  height: 700px;
}

.search {
  margin: 100px 0;
}

.s1{
  margin-right:742px;
}
</style>