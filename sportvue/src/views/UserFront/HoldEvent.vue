<template>
    <h1>HoldEvent</h1>
    <el-form
      ref="ruleFormRef"
      :model="ruleForm"
      :rules="rules"
      label-width="120px"
      class="form"
      :size="formSize"
      status-icon
    >
      <el-form-item label="Event Name" prop="ename">
        <el-input v-model="ruleForm.ename" />
      </el-form-item>
      <el-form-item label="Event zone" prop="eplace">
        <el-select v-model="ruleForm.eplace" placeholder="Event zone">
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
      <el-form-item label="Players" prop="count">
        <el-select-v2
          v-model="ruleForm.count"
          placeholder="Activity count"
          :options="options"
        />
      </el-form-item>
      <el-form-item label="Activity time" required>
        <el-col :span="11">
          <el-form-item prop="date1">
            <el-date-picker
              v-model="ruleForm.date1"
              type="date"
              label="Pick a date"
              placeholder="Pick a date"
              style="width: 100%"
            />
          </el-form-item>
        </el-col>
        <el-col class="text-center" :span="2">
          <span class="text-gray-500">-</span>
        </el-col>
        <el-col :span="11">
          <el-form-item prop="date2">
            <el-time-picker
              v-model="ruleForm.date2"
              label="Pick a time"
              placeholder="Pick a time"
              style="width: 100%"
            />
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="Activity type" prop="type">
        <el-input style="width: 100px;" v-model="ruleForm.ename" />
      </el-form-item>
      <el-form-item label="Resources" prop="resource">
        <el-radio-group v-model="ruleForm.resource">
          <el-radio label="Sponsorship" />
          <el-radio label="Venue" />
        </el-radio-group>
      </el-form-item>
      <el-form-item label="Activity form" prop="desc">
        <el-input v-model="ruleForm.desc" type="textarea" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm(ruleFormRef)">
          Create
        </el-button>
        <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
      </el-form-item>
    </el-form>
  </template>
  
  <script lang="ts" setup>
  import { reactive, ref } from 'vue'
  import type { FormInstance, FormRules } from 'element-plus'
  
  const formSize = ref('default')
  const ruleFormRef = ref<FormInstance>()
  const ruleForm = reactive({
    ename: '',
    eplace: '',
    count: '',
    date1: '',
    date2: '',
    delivery: false,
    type: [],
    resource: '',
    desc: '',
  })
  
  const rules = reactive<FormRules>({
    ename: [
      { required: true, message: 'Please input Event name', trigger: 'blur' },
    ],
    eplace: [
      {
        required: true,
        message: 'Please select Event zone',
        trigger: 'change',
      },
    ],
    count: [
      {
        required: true,
        message: 'Please select Activity count',
        trigger: 'change',
      },
    ],
    date1: [
      {
        type: 'date',
        required: true,
        message: 'Please pick a date',
        trigger: 'change',
      },
    ],
    date2: [
      {
        type: 'date',
        required: true,
        message: 'Please pick a time',
        trigger: 'change',
      },
    ],
    type: [
      {
        type: 'array',
        required: true,
        message: 'Please select at least one activity type',
        trigger: 'change',
      },
    ],
    resource: [
      {
        required: true,
        message: 'Please select activity resource',
        trigger: 'change',
      },
    ],
    desc: [
      { required: true, message: 'Please input activity form', trigger: 'blur' },
    ],
  })
  
  const submitForm = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
      if (valid) {
        console.log('submit!')
      } else {
        console.log('error submit!', fields)
      }
    })
  }
  
  const resetForm = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    formEl.resetFields()
  }
  
  const options = Array.from({ length: 10000 }).map((_, idx) => ({
    value: `${idx + 1}`,
    label: `${idx + 1}`,
  }))
  </script>
  <style>
  .form{
    width: 750px;
  }
  </style>
  