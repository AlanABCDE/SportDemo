<template>
  <div class="body">
    <h1>管理我的赛事</h1>
      <div class="search">
          <el-input style="width: 200px" placeholder="请输入举办人姓名" suffix-icon="el-icon-search" v-model="selteamName"></el-input>
          <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
          <el-button type="warning" @click="reset">重置</el-button>
      </div>
      <el-table :data="tableData" style="width: 100%;height: 300px;">
          <el-table-column prop="eventId" label="比赛编号" width="180" />
          <el-table-column prop="eventName" label="比赛名称" width="180" />
          <el-table-column prop="eventDis" label="比赛描述" width="180" />
          <el-table-column label="操作" >
            <el-button>管理</el-button>
            <el-button>删除</el-button>
        </el-table-column>
      </el-table>
  </div>
</template>
<script>
import axios from 'axios';


export default {
  data() {
      return {
          tableData: [],
          selteamName:'',
      }
  },
  created() {
  },
  methods: {
      load(){
          axios.get("http://localhost:9090/event/selEvent/"+this.selteamName,{
          })
          .then(res => {
              console.log(JSON.stringify(res.data.data))
              this.tableData=res.data.data
              console.log("-------------------------------")
              console.log(JSON.stringify(this.tableData.data))
          })
      },
      reset() {
          this.selteamName=''
          //this.load()
      }
  }
}

</script>
<style>
.body{
  width: 1000px; 
  margin: 0px auto;
  height: 700px;
}
.search {
  margin: 100px 0;
}
</style>