<template>
  <h1>EventList</h1>
  <el-table :data="tableData.slice((page - 1) * limit, page * limit)" style="width: 100%">
    <el-table-column prop="eventId" label="赛事编号"  />
    <el-table-column prop="eventName" label="赛事名称"  />
    <el-table-column prop="eventDate" label="赛事日期"  />
    <el-table-column prop="eventTime" label="赛事时间"  />
    <el-table-column prop="eventZone" label="赛事场地"  />
    <el-table-column prop="eventDis" label="赛事描述" />
    <el-table-column prop="eventPlayernumber" label="参赛人数" />
    <el-table-column prop="eventHolder" label="举办人" />
  </el-table>
  <el-pagination :current-page="page" :page-size="limit" :page-sizes="[5, 10, 15, 20]" background
    layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
    @current-change="handleCurrentChange" />
</template>

<script >
import axios from 'axios';
import { ref } from 'vue'
const dialogVisible = ref(false)
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
    }
  }
}
</script>
<style>
.el-scrollbar{
  width: 1200px;
}
</style>

