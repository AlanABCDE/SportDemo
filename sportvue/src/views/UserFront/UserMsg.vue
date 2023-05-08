<template>
  <h1>查看通知</h1>
  <div class="msgbox">
    <el-table :data="tableData.slice((page - 1) * limit, page * limit)">
      <el-table-column prop="msgId" label="编号" width="180" />
      <el-table-column prop="title" label="标题" width="180" />
      <el-table-column prop="createTime" label="发布日期" width="150" />
      <el-table-column fixed="right" label="操作" width="180">
        <template v-slot="scope">
          <el-button link type="primary" size="small" @click="check(scope.row.msgId)">详情</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination :current-page="page" :page-size="limit" :page-sizes="[5, 10, 15, 20]" background
      layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
      @current-change="handleCurrentChange" />
  </div>
  <el-dialog title="详情" v-model="dialogVisible" width="800px" height="800px">
    <el-form :inline="false" :label-position="labelPosition" :model="formInline" label-width="100px">
      <el-form-item label="标题" prop="title">
        <el-input v-model="msgData.title" disabled />
      </el-form-item>
      <el-form-item label="内容" prop="content">
        <el-input v-model="msgData.content" autosize type="textarea" disabled />
      </el-form-item>
      <el-form-item label="发布日期" prop="createTime">
        <el-input v-model="msgData.createTime" disabled />
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="dialogVisible = false">关 闭</el-button>
    </span>
  </el-dialog>
</template>
  
<script>
import axios from 'axios';
export default {
  data() {
    return {
      tableData: [
        {
          msgId: '',
          title: '',
          content: '',
          createTime: '',
        },
      ],
      msgData: {},
      dialogVisible: false,
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
    check(id) {
      this.tableData.forEach((item) => {
        if (item.msgId == id) {
          this.msgData = item
        }
      })
      this.dialogVisible = true
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
.msgbox {
  width: 1300px;
  padding-left: 500px;
  background-color: rgb(255, 255, 255);
}

.el-scrollbar {
  margin-right: 600px;
}
</style>