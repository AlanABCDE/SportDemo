<template>
    <h1>ManageMyEvent</h1>
    <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="eid" label="赛事编号" width="180" />
      <el-table-column prop="ename" label="赛事名称" width="180" />
      <el-table-column prop="edate" label="赛事日期" width="180" />
      <el-table-column prop="etime" label="赛事时间" width="180" />
      <el-table-column prop="eplace" label="赛事场地" width="180" />
      <el-table-column prop="edis" label="赛事描述" />
      <el-table-column fixed="right" label="Operations" width="120">
        <template #default>
          <el-button link type="primary" size="small" @click="handleClick"
            >Delete</el-button
          >
          <el-button link type="primary" size="small" @click="dialogVisible = true">Edit</el-button>
          <el-dialog
      v-model="dialogVisible"
      title="Tips"
      width="30%"
      :before-close="handleClose"
    >
      <span>This is a message</span>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">Cancel</el-button>
          <el-button type="primary" @click="dialogVisible = false">
            Confirm
          </el-button>
        </span>
      </template>
    </el-dialog>
        </template>
      </el-table-column>
    </el-table>
  </template>
  
  <script >
  import  axios from 'axios';
  import { ref } from 'vue'
  const dialogVisible = ref(false)
    export default {
        data(){
            return {
                tableData: [
                    {   
                        eid:'',
                        ename:'' ,
                        edate:'',
                        etime:'',
                        eplace:'',
                        edis:''
                    },
                ],
            }
        },
        created() {
            const  _this=this
            axios.get("http://localhost:9090/event/getEvent").then(function(res){
                _this.tableData=res.data;
            })
            // axios.post("http://localhost:8181/demo/phb",this.phb).then(function (res) {
            //     console.log(res.data);
            //     _this.phb = res.data;
            // })
        },
        // methods:{
        //     go(id){
        //         const  _this=this
        //         console.log(id)
        //         _this.Can.user_id=sessionStorage.getItem('user_id')
        //         this.$router.push({path:'drawingpage',query:{id:id,uid:_this.Can.user_id}})
        //     }
        // }
        methods:{
          handleClick(){
  
          }
        }
    }
  
  </script>
  
  