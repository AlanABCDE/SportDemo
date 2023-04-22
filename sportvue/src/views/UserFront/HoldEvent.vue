<template>
  <h1>赛事创建</h1>
  <div class="divform">
    <el-form ref="ruleFormRef" :model="tableData" :rules="rules" label-width="120px" class="form" :size="formSize"
      status-icon>
      <el-form-item label="赛事名称" prop="eventName">
        <el-input v-model="tableData.eventName" />
      </el-form-item>
       <el-form-item label="比赛场地" prop="eventZone">
        <el-select v-model="tableData.eventZone" placeholder="选择一个场地">
          <el-option label="篮球场1" value="篮球场1" />
          <el-option label="篮球场2" value="篮球场2" />
          <el-option label="篮球场3" value="篮球场3" />
          <el-option label="足球场1" value="足球场1" />
          <el-option label="足球场2" value="足球场2" />
          <el-option label="网球场1" value="网球场1" />
          <el-option label="网球场2" value="网球场2" />
          <el-option label="网球场3" value="网球场3" />
        </el-select>
      </el-form-item>
      <el-form-item label="比赛时间" required>
        <el-col :span="11">
          <el-form-item prop="eventDate">
            <el-date-picker v-model="tableData.eventDate" type="date" label="Pick a date" placeholder="选个日期"
              style="width: 100%" />
          </el-form-item>
        </el-col>
        <el-col class="text-center" :span="2">
          <span class="text-gray-500">-</span>
        </el-col>
        <el-col :span="11">
          <el-form-item prop="eventTime">
            <el-time-picker v-model="tableData.eventTime" label="Pick a time" placeholder="选个日期" style="width: 100%" />
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="比赛人数" prop="eventPlayernumber">
        <el-input style="width: 100px;" v-model="tableData.eventPlayernumber" />
      </el-form-item>
      <el-form-item label="承办人姓名" prop="eventHolder">
        <el-input v-model="tableData.eventHolder" />
      </el-form-item>
      <el-form-item label="赛事描述" prop="eventDis">
        <el-input v-model="tableData.eventDis" type="textarea" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">
          提交
        </el-button>
        <el-button @click="resetForm('formName')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
  
<script>
import axios from 'axios';
import { ref } from 'vue'
const formSize = ref('default')

export default {
  data() {
    return {
      tableData: {
        
          eventId: '',
          eventName: '',
          eventDate: '',
          eventTime: '',
          eventZone: '',
          eventDis: '',
          eventPlayernumber: '',
          eventHolder: '',
        },
      options:{

      },
      rules: {
        eventName: [
          { required: true, 
            message: '请输入个比赛名称', 
            trigger: 'blur' },
        ],
        eventHolder: [
          { required: true, 
            message: '请输入承办人姓名', 
            trigger: 'blur' },
        ],
        eventZone: [
          {
            required: true,
            message: '请选择比赛场地',
            trigger: 'blur',
          },
        ],
        eventPlayernumber: [
          {
            required: true,
            message: '请输入比赛人数',
            trigger: 'blur',
          },
        ],
        eventDate: [
          {
            type: 'date',
            required: true,
            message: '请选择比赛日期',
            trigger: 'blur',
          },
        ],
        eventTime: [
          {
            type: 'date',
            required: true,
            message: '请选择比赛时间',
            trigger: 'blur',
          },
        ],
        eventDis: [
          { required: true, 
            message: '请输入比赛描述', 
            trigger: 'blur' },
        ],
      }
    }
  },
  created() {
    
  },
  methods:{
    resetForm() {
        this.eventName = '',
        this.eventPlayernumber = '',
        this.eventHolder = '',
        this.eventDate = '',
        this.eventTime = '',
        this.eventDis = '',
        this.eventZone = ''
      },
      submit() {
        console.log(this.tableData)
        axios.post("http://localhost:9090/event/holdEvent", this.tableData).then(res => {
              if(res.data.code === '200') {
                this.$message.success("添加成功")
              } else {
                this.$message.error(res.data.msg)
              }
            })
      }

  }
}
</script>
<style>
.form {
  width: 750px;
}

.divform {
  width: 800px;
  padding-left: 500px;

}
</style>
  