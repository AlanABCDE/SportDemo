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
        <el-button link type="primary" size="small" @click="open">我要报名</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination :current-page="page" :page-size="limit" :page-sizes="[5, 10, 15, 20]" background
    layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
    @current-change="handleCurrentChange" />

  <el-dialog v-model="dialogVisible1" title="详情" width="800px">
    <el-form model="eventData" label-width="100px" class="form" :size="formSize">
      <el-form-item label="比赛名称" prop="eventName">
        <el-input v-model="eventData.eventName" placeholder=eventData.eventName disabled/>
      </el-form-item>
      <el-form-item label="比赛日期" prop="eventDate">
        <el-input v-model="eventData.eventDate" placeholder=eventData.eventDate disabled/>
      </el-form-item>
      <el-form-item label="比赛时间" prop="eventTime">
        <el-input v-model="eventData.eventTime" placeholder=eventData.eventTime disabled/>
      </el-form-item>
      <el-form-item label="比赛地点" prop="eventZone">
        <el-input v-model="eventData.eventZone" placeholder=eventData.eventZone disabled/>
      </el-form-item>
      <el-form-item label="参加人数" prop="eventPlayernumber,eventJoinednumber">
        <el-input v-model="eventData.eventJoinednumber" placeholder=eventData.eventJoinednumber disabled/>
        <el-input v-model="eventData.eventPlayernumber" placeholder=eventData.eventPlayernumber disabled/>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>
  
<script >
import axios from 'axios';
export default {
  data() {
    return {
      dialogVisible1: false,
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
    handleClick() {
    },
    handleSizeChange(val) {
      this.limit = val
      this.page = 1
    },
    handleCurrentChange(val) {
      this.page = val
    },
    eventDetail(id){
      this.tableData.forEach((item) => {
        if (item.eventId == id) {
          this.eventData = item
        }
      })
      this.dialogVisible1 = true
    },
    open() {
        this.$confirm('此操作完成报名操作, 是否继续?', '提示', {
          confirmButtonText: '好，我冲！',
          cancelButtonText: '不好，跑了！',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '报名成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消报名'
          });          
        });
      }

  }
}

</script>
  
  