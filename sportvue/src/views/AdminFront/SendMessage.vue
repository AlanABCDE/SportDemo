<template>
  <h1>通知管理</h1>
  <el-button class="b1" @click="dialogVisible2 = true" type="primary">新增通知</el-button>
  <div class="msgbox">
    <el-table :data="tableData.slice((page - 1) * limit, page * limit)">
      <el-table-column prop="msgId" label="编号" width="180" />
      <el-table-column prop="title" label="标题" width="180" />
      <el-table-column prop="createTime" label="发布日期" width="180" />
      <el-table-column prop="manage" label="管理" width="180">
      <template v-slot="scope">
        <el-button type="success" @click="updateButton(scope.row.msgId)">管理<i class="el-icon-edit"></i></el-button>
        <el-button type="danger"  @click="deleteMsg(scope.row.msgId)">删了</el-button>
      </template>
      </el-table-column>
    </el-table>
    <el-pagination 
          class="span" 
          :current-page="page" 
          :page-size="limit" 
          :page-sizes="[5, 10, 15, 20]" background
          layout="total, sizes, prev, pager, next, jumper" 
          :total="total" 
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange" />
  </div>
  <el-dialog v-model="dialogVisible1" title="修改通知" width="30%" >
    <el-form ref="form" :model="formData2" label-width="80px">
      <el-form-item label="编号">
        <el-input v-model="formData2.msgId" disabaled></el-input>
      </el-form-item>
      <el-form-item label="标题">
        <el-input v-model="formData2.title"></el-input>
      </el-form-item>
      <el-form-item label="内容">
        <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4 }" placeholder="请输入内容" v-model="formData2.content">
        </el-input>
      </el-form-item>
      <el-form-item label="活动时间">
        <el-col :span="11">
          <el-date-picker type="date" placeholder="选择日期" v-model="formData2.createTime" style="width: 100%;"></el-date-picker>
        </el-col>
        <el-col class="line" :span="2">-</el-col>
        <el-col :span="11">
          <el-time-picker type="time"  placeholder="选择时间" v-model="formData2.createTime" style="width: 100%;"></el-time-picker>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="update">立即修改</el-button>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible1 = false">不改了</el-button>
      </span>
    </template>
  </el-dialog>
  <el-dialog v-model="dialogVisible2" title="新增通知" width="30%" >
    <el-form ref="form" :model="formData" label-width="80px">
      <el-form-item label="标题">
        <el-input v-model="formData.title"></el-input>
      </el-form-item>
      <el-form-item label="内容">
        <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4 }" placeholder="请输入内容" v-model="formData.content">
        </el-input>
      </el-form-item>
      <el-form-item label="活动时间">
        <el-col :span="11">
          <el-date-picker type="date" placeholder="选择日期" v-model="formData.createTime" style="width: 100%;"></el-date-picker>
        </el-col>
        <el-col class="line" :span="2">-</el-col>
        <el-col :span="11">
          <el-time-picker type="time" placeholder="选择时间" v-model="formData.createTime" style="width: 100%;"></el-time-picker>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即添加</el-button>

      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible2 = false">不添加了</el-button>
      </span>
    </template>
  </el-dialog>
</template>
  
<script >
import axios from 'axios';
export default {
  data() {
    return {
      dialogVisible2 : false,
      tableData: [
        {
          msgId: '',
          title: '',
          content: '',
          createTime: '',
        },
      ],
      formData:
      {
        msgId:'',
        title: '',
        content: '',
        createTime: '',
      },
      formData2:{},
      page: 1,
      limit: 5,
      total: 0,
      dialogVisible: false,
      dialogVisible1: false
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
    load(){
      axios.get("http://localhost:9090/msg/getMsg")
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
    onSubmit() {
      console.log(this.formData)
      axios.post("http://localhost:9090/msg/addMsg", this.formData).then(res => {
        if (res.data.code === '200') {
          this.$message.success("添加成功")
          this.load()
          this.dialogVisible2 = false
        } else {
          this.$message.error(res.data.msg)
        }
        dialogVisible = false
      })
    },
    update() {
      console.log(this.formData2)
      axios.post("http://localhost:9090/msg/updateMsg", this.formData2).then(res => {
        if (res.data.code === '200') {
          this.$message.success("修改成功")
          this.dialogVisible1 = false
          this.load()
        } else {
          this.$message.error(res.data.msg)
        }
      })
      
      
    },
    deleteMsg(msgId) {
      console.log(msgId)
      axios.delete("http://localhost:9090/msg/" + msgId).then(res => {
        if (res) {
          this.$message.success("删除成功")
          this.load()
        } else {
          this.$message.error("删除失败")
        }
      })
    },
    updateButton(id){
      this.tableData.forEach((item) => {
        if (item.msgId == id) {
          this.formData2 = item
        }
      })
      this.dialogVisible1 = true

    }
  }
}

</script>
<style>
.el-table__header-wrapper {
  margin-left: 473px;
}

.span {
  margin-left: 473px;
}

.b1 {
  margin-left: -631px;
}
</style>
  
  