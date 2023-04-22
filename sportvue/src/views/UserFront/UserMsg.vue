<template>
  <h1>查看通知</h1>
  <div class="msgbox">
    <el-table :data="tableData.slice((page - 1) * limit, page * limit)">
      <el-table-column prop="msgId" label="编号" width="180" />
      <el-table-column prop="title" label="标题" width="180" />
      <el-table-column prop="date" label="发布日期" width="150" />
      <el-table-column fixed="right" label="Operations" width="180">
        <template #default>
          <el-button link type="primary" size="small" @click="dialogVisible = true">Detail</el-button>
          <el-dialog title="提示" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
            <span>这是一段信息</span>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
            </span>
          </el-dialog>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination :current-page="page" :page-size="limit" :page-sizes="[5, 10, 15, 20]" background
      layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
      @current-change="handleCurrentChange" />
  </div>
</template>
  
<script>
import axios from 'axios';

export default {
  data() {
    return {
      dialogVisible: false,
      tableData: [
        {
          msgId: '',
          title: '',
          content: '',
          date: '',
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
    handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
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
  
  