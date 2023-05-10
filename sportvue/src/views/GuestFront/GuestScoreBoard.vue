<template>
  <h1>赛事成绩浏览</h1>
  
  <el-table :data="tableData.slice((page - 1) * limit, page * limit)" style="width: 100%">
  <el-table-column prop="matchId" label="成绩编号" width="180" />
  <el-table-column prop="eventName" label="赛事名称" width="180" />
  <el-table-column prop="eventDate" label="赛事日期" width="180" />
  <el-table-column prop="eventTime" label="赛事时间" width="180" />
  <el-table-column prop="eventZone" label="赛事场地" width="180" />
  <el-table-column prop="matchStatus" label="比赛状态" />
  <el-table-column fixed="right" label="操作" width="120">
    <template v-slot="scope">
      <el-button link type="primary" size="small" @click="MatchDetail(scope.row.matchId)">看看比分</el-button>
    </template>
  </el-table-column>
</el-table>
<el-pagination :current-page="page" :page-size="limit" :page-sizes="[5, 10, 15, 20]" background
  layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
  @current-change="handleCurrentChange" />

  <el-dialog v-model="dialogVisible" title="开始上分">
    <el-form :inline="false" :label-position="labelPosition" v-model="formData" >
      <el-form-item label="比赛名称">
        <el-input v-model="formData.eventName" disabled></el-input>
      </el-form-item>
      <el-form-item label="比赛状态" prop="matchStatus">
        <el-col :span="16">
          <el-select v-model="formData.matchStatus" placeholder="选择一个状态" disabled>
          <el-option label="未开始" value="未开始" />
          <el-option label="进行中" value="进行中" />
          <el-option label="已结束" value="已结束" />
        </el-select>
        </el-col>
      </el-form-item>
      <el-form-item label="比赛得分">
        <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4 }" placeholder="请输入内容" v-model="formData.matchScore" disabled>
        </el-input>
      </el-form-item>
      <el-form-item label="比赛选手">
        <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4 }" placeholder="请输入内容" v-model="formData.matchPlayer" disabled>
        </el-input>
      </el-form-item>
      <el-form-item label="比赛排名">
        <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4 }" placeholder="请输入内容" v-model="formData.matchRank" disabled>
        </el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">关闭</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script>
import axios from 'axios';
export default {
  data(){
    return{
      dialogVisible: false,
      tableData:[
        {
          matchId:'',
          eventId:'',
          eventName:'',
          matchStatus:'',
          eventZone:'',
          eventDate:'',
          eventTime:'',
          matchScore:'',
          matchPlayer:'',
          matchRank:'',
        }
      ],
      formData:{},
      page: 1,
      limit: 5,
      total: 0,
    }
  },
  created(){
    axios.get("http://localhost:9090/match/getMatch")
      .then(res => {
        console.log(res)
        this.tableData = [...res.data]
        this.total = res.data.length
        console.log(this.total)
      })
  },
  methods:{
    load(){
      axios.get("http://localhost:9090/match/getMatch")
      .then(res => {
        console.log(res)
        this.tableData = [...res.data]
        this.total = res.data.length
        console.log(this.total)
      })
    },
    handleSizeChange(val) {
      this.limit = val
      this.page = 1
    },
    handleCurrentChange(val) {
      this.page = val
    },
    MatchDetail(id){
      this.tableData.forEach((item) => {
        if (item.matchId == id) {
          this.formData = item
        }
      })
      this.dialogVisible = true
    },
  },
}
</script>

<style>
body {
  margin: 0;
}
.example-showcase .el-loading-mask {
  z-index: 9;
}
</style>
