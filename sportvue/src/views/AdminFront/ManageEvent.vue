<template v-slot="scope">
  <h1>EventManage</h1>
  <el-table :data="tableData.slice((page - 1) * limit, page * limit)" style="width: 100%" @row-click="getrowid">
    <el-table-column prop="id" label="赛事编号" width="180" />
    <el-table-column prop="eventName" label="赛事名称" width="180" />
    <el-table-column prop="eventDate" label="赛事日期" width="180" />
    <el-table-column prop="eventTime" label="赛事时间" width="180" />
    <el-table-column prop="eventZone" label="赛事场地" width="180" />
    <el-table-column prop="eventDis" label="赛事描述" />
    <el-table-column prop="eventPlayernumber" label="参赛人数" />
    <el-table-column prop="eventHolder" label="举办人" />

    <el-table-column label="操作" >
      <el-button @click="edit()">Edit</el-button>
      <el-popconfirm
    confirm-button-text="Yes"
    cancel-button-text="No"
    :icon="InfoFilled"
    icon-color="#626AEF"
    title="Are you sure to delete this?"
    @confirm="del()"
    @cancel="cancelEvent"
  >
    <template #reference>
      <el-button>Delete</el-button>
    </template>
  </el-popconfirm>
    </el-table-column>

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
          id: '',
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
      rowid:'',
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
    getrowid(){
      rowid = row
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
    del(rowid) {
      if(rowid.val){
        axios.delete("http://localhost:9090/event/" + this.rowid)
        this.$message.success("ok")
      }else{
            this.$message.error("g")
          }
        }
    },

  }

</script>
  
  