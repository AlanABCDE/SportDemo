<template v-slot="scope">
  <h1>赛事管理</h1>

  <div>
    <el-button class="b1" @click="checkEvent">看看报名名单</el-button>
  </div>
  <el-table :data="tableData.slice((page - 1) * limit, page * limit)" style="width: 100%" @row-click="getrowid">
    <el-table-column prop="eventId" label="赛事编号" width="180" />
    <el-table-column prop="eventName" label="赛事名称" width="180" />
    <el-table-column prop="eventDate" label="赛事日期" width="180" />
    <el-table-column prop="eventTime" label="赛事时间" width="180" />
    <el-table-column prop="eventZone" label="赛事场地" width="180" />
    <el-table-column prop="eventDis" label="赛事描述" />
    <el-table-column prop="eventPlayernumber" label="参赛人数" />
    <el-table-column prop="eventHolder" label="举办人" />
    <el-table-column label="操作">
      <template v-slot="scope">
      <el-button @click="managerevent(scope.row.eventId)">管理</el-button>
      <el-popconfirm confirm-button-text="对！" cancel-button-text="后悔了" :icon="InfoFilled" icon-color="#626AEF"
        title="真删假删?" @confirm="del(scope.row.eventId)" @cancel="cancelEvent">
        <template #reference>
          <el-button>删了！</el-button>
        </template>
      </el-popconfirm>
    </template>
    </el-table-column>

  </el-table>
  <el-pagination :current-page="page" :page-size="limit" :page-sizes="[5, 10, 15, 20]" background
    layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
    @current-change="handleCurrentChange" />

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
      <el-form-item label="已参加人数" prop="eventJoinednumber">
        <el-input style="width: 100px;" v-model="managerData.eventJoinednumber" />
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
import { ref } from 'vue'
export default {
  data() {
    return {
      tableData: [
        {
          eventId: '',
          eventName: '',
          eventDate: '',
          eventTime: '',
          eventZone: '',
          eventDis: '',
          eventPlayernumber: '',
          eventJoinednumber: '',
          eventHolder: '',
        },
      ],
      managerData: {},
      signData:{},
      signData2:{},
      dialogVisible1: false,
      dialogVisible2: false,
      page: 1,
      limit: 5,
      total: 0
    }
  },
  created() {
    axios.get("http://localhost:9090/event/getEvent")
      .then(res => {
        console.log(res)
        this.tableData = [...res.data]
        this.total = res.data.length
      }),
      axios.get("http://localhost:9090/sign/getUser")
      .then(res => {
        console.log(res)
        this.signData = res.data
        console.log("-----111------")
        console.log(this.signData)
      })
  },
  methods: {
    load(){
      axios.get("http://localhost:9090/event/getEvent")
      .then(res => {
        console.log(res)
        this.tableData = [...res.data]
        this.total = res.data.length
      })
    },
    handleSizeChange(val) {
      this.limit = val
      this.page = 1
    },
    handleCurrentChange(val) {
      this.page = val
    },
    del(eventId) {
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
    },
    checkEvent(){
      this.dialogVisible2 = true
      this.signData2 = this.signData
      console.log(this.signData2)
    }
  },

}

</script>
<style>
.b1{
  margin-right: 1700px;
}
</style>
  
  