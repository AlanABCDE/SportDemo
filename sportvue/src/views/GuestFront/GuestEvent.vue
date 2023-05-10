<template>
  <h1>参加赛事</h1>
  <el-table :data="tableData.slice((page - 1) * limit, page * limit)" style="width: 100%">
    <el-table-column prop="eventId" label="赛事编号" width="180" />
    <el-table-column prop="eventName" label="赛事名称" width="180" />
    <el-table-column prop="eventDate" label="赛事日期" width="180" />
    <el-table-column prop="eventTime" label="赛事时间" width="180" />
    <el-table-column prop="eventZone" label="赛事场地" width="180" />
    <el-table-column prop="eventDis" label="赛事描述" />
    <el-table-column prop="eventPlayernumber" label="参赛人数" />
    <el-table-column prop="eventHolder" label="举办人" />
    <el-table-column fixed="right" label="操作" width="120">
      <template v-slot="scope">
        <el-button link type="primary" size="small" @click="eventDetail(scope.row.eventId)">详情</el-button>
        <el-button disabled  link type="primary" size="small" @click="sign(scope.row.eventId)">我要报名</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination :current-page="page" :page-size="limit" :page-sizes="[5, 10, 15, 20]" background
    layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
    @current-change="handleCurrentChange" />

  <el-dialog v-model="dialogVisible1" title="详情" width="800px">
    <el-form model="eventData" label-width="100px" class="form" :size="formSize">
      <el-form-item label="比赛名称" prop="eventName">
        <el-input v-model="eventData.eventName" placeholder=eventData.eventName disabled />
      </el-form-item>
      <el-form-item label="比赛日期" prop="eventDate">
        <el-input v-model="eventData.eventDate" placeholder=eventData.eventDate disabled />
      </el-form-item>
      <el-form-item label="比赛时间" prop="eventTime">
        <el-input v-model="eventData.eventTime" placeholder=eventData.eventTime disabled />
      </el-form-item>
      <el-form-item label="比赛地点" prop="eventZone">
        <el-input v-model="eventData.eventZone" placeholder=eventData.eventZone disabled />
      </el-form-item>
      <el-form-item label="参加人数" prop="eventPlayernumber,eventJoinednumber">
        <el-input v-model="eventData.eventJoinednumber" placeholder=eventData.eventJoinednumber disabled />
        <el-input v-model="eventData.eventPlayernumber" placeholder=eventData.eventPlayernumber disabled />
      </el-form-item>
    </el-form>
  </el-dialog>
  <el-dialog v-model="dialogVisible2" width="350px">
    <span>确认报名吗？报名后不可取消。</span>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible2 = false">那算了</el-button>
        <el-button type="primary" @click="submit">报名！</el-button>
      </span>
    </template>
  </el-dialog>
</template>
  
<script >
import axios from 'axios';
export default {
  data() {
    return {
      dialogVisible1: false,
      dialogVisible2: false,
      join: false,
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
      eventData:{},
      id: '',
      joinedplayer: '',
      totalplayer: '',
      page: 1,
      limit: 5,
      total: 0
    }
  },
  created() {
    const _this = this
    axios.get("http://localhost:9090/event/getEvent")
      .then(res => {
        console.log(res)
        this.tableData = [...res.data]
        this.total = res.data.length
      })
  },
  methods: {
    load() {
      axios.get("http://localhost:9090/event/getEvent")
        .then(res => {
          console.log(res)
          this.tableData = [...res.data]
          this.total = res.data.length
        })
    },
    handleClick() {
    },
    handleSizeChange(val) {
      this.limit = val
      this.page = 1
    },
    handleCurrentChange(val) {
      this.page = val
    },
    eventDetail(id) {
      this.tableData.forEach((item) => {
        if (item.eventId == id) {
          this.eventData = item
        }
      })
      this.dialogVisible1 = true
    },
    sign(id) {
      this.tableData.forEach((item) => {
        if (item.eventId == id) {
          this.id = item.eventId
          this.totalplayer = item.eventPlayernumber
          this.joinedplayer = item.eventJoinednumber

        }
      })
      this.dialogVisible2 = true
    },
    submit() {
      console.log(this.id)
      console.log("---------------")
      console.log(this.totalplayer)
      console.log(this.joinedplayer)
      if (this.joinedplayer + 1 <= this.totalplayer) {
        axios.post("http://localhost:9090/event/joinEvent/" + this.id)
        .then(res => {
        if (res.data.code === '200') {
          this.$message.success("修改成功")
          this.dialogVisible2 = false
          this.load()
        } else {
          this.$message.error(res.data.msg)
        }
      })
      } else {
        this.$message.error("人满了，不能报名")
      }
    },
  }
}

</script>
  
  