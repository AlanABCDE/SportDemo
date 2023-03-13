<template>
    <h1>SendMessage</h1>
    <div class="msgbox">
    <el-table :data="tableData.slice((page - 1) * limit, page * limit)" >
      <el-table-column prop="id" label="编号" width="180" />
      <el-table-column prop="title" label="标题" width="180" />
      <el-table-column prop="date" label="发布日期" width="180" />
      <el-table-column prop="uploader" label="发布人" width="180" />
      <el-table-column fixed="right" label="Operations" width="180">
        <template #default>
          <el-button link type="primary" size="small" @click="dialogVisible = true">Detail</el-button>
          <el-button link type="primary" size="small" @click="dialogVisible = true">Edit</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination :current-page="page" :page-size="limit" :page-sizes="[5, 10, 15, 20]" background
      layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
      @current-change="handleCurrentChange" />
    </div>
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
            title: '',
            content: '',
            date: '',
            uploader: '',
          },
        ],
        page: 1,
        limit: 5,
        total: 0
      }
    },
    created() {
      axios.get("http://localhost:9090/msg/getMsg")
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
.msgbox{
  width: 1200px;
  margin-left: 250px;
  background-color: rgb(255, 255, 255);
}
.el-scrollbar{
margin-right: 300px;
}
</style>
  
  