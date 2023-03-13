<template>
  <h1>HoldEvent</h1>
  <div class="divform">
    <el-form ref="ruleFormRef" :model="tableData" :rules="rules" label-width="120px" class="form" :size="formSize"
      status-icon>
      <el-form-item label="Event Name" prop="eventName">
        <el-input v-model="tableData.eventName" />
      </el-form-item>
       <el-form-item label="Event zone" prop="eventZone">
        <el-select v-model="tableData.eventZone" placeholder="Event zone">
          <el-option label="Basketball Court 1" value="Basketball Court 1" />
          <el-option label="Basketball Court 2" value="Basketball Court 2" />
          <el-option label="Basketball Court 3" value="Basketball Court 3" />
          <el-option label="Basketball Court 4" value="Basketball Court 4" />
          <el-option label="Soccer Court 1" value="Soccer Court 1" />
          <el-option label="Soccer Court 2" value="Soccer Court 2" />
          <el-option label="Soccer Court 3" value="Soccer Court 3" />
          <el-option label="Soccer Court 4" value="Soccer Court 4" />
        </el-select>
      </el-form-item>
      <el-form-item label="Activity time" required>
        <el-col :span="11">
          <el-form-item prop="eventDate">
            <el-date-picker v-model="tableData.eventDate" type="date" label="Pick a date" placeholder="Pick a date"
              style="width: 100%" />
          </el-form-item>
        </el-col>
        <el-col class="text-center" :span="2">
          <span class="text-gray-500">-</span>
        </el-col>
        <el-col :span="11">
          <el-form-item prop="eventTime">
            <el-time-picker v-model="tableData.eventTime" label="Pick a time" placeholder="Pick a time" style="width: 100%" />
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="Activity Size" prop="eventPlayernumber">
        <el-input style="width: 100px;" v-model="tableData.eventPlayernumber" />
      </el-form-item>
      <el-form-item label="eventHolder" prop="eventHolder">
        <el-input v-model="tableData.eventHolder" />
      </el-form-item>
      <el-form-item label="Activity form" prop="eventDis">
        <el-input v-model="tableData.eventDis" type="textarea" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">
          Create
        </el-button>
        <el-button @click="resetForm('formName')">Reset</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
  
<script>
import { ref } from 'vue'
const formSize = ref('default')

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
          eventHolder: '',
        }
      ],
      options:{

      },
      rules: {
        eventName: [
          { required: true, 
            message: 'Please input Event name', 
            trigger: 'blur' },
        ],
        eventHolder: [
          { required: true, 
            message: 'Please input Holder name', 
            trigger: 'blur' },
        ],
        eventZone: [
          {
            required: true,
            message: 'Please select Event zone',
            trigger: 'blur',
          },
        ],
        eventPlayernumber: [
          {
            required: true,
            message: 'Please select Activity count',
            trigger: 'blur',
          },
        ],
        eventDate: [
          {
            type: 'date',
            required: true,
            message: 'Please pick a date',
            trigger: 'blur',
          },
        ],
        eventTime: [
          {
            type: 'date',
            required: true,
            message: 'Please pick a time',
            trigger: 'blur',
          },
        ],
        eventDis: [
          { required: true, 
            message: 'Please input activity form', 
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
  