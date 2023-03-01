<template>
  <el-table :data="tableData.slice((page - 1)*limit,page * limit)" style="width: 100%">
  <el-table-column prop="uid" label="编号" width="180" />
    <el-table-column prop="username" label="名字" width="180" />
    <el-table-column prop="password" label="密码" width="180" />
    <el-table-column prop="sex" label="性别" width="180" />
    <el-table-column prop="role" label="角色" width="180" />
    <el-table-column prop="email" label="邮件" />
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
  <el-pagination
      :current-page="page"
      :page-size="limit"
      :page-sizes="[5, 10, 15, 20]"
      background
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
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
                      uid:'',
                      username:'' ,
                      sex:'',
                      password:'',
                      role:'',
                  },
              ],
              page: 1,
              limit: 5,
              total: 0
          }
      },
      created() {
          axios.get("http://localhost:9090/user/getUser")
          .then(res => {
            console.log(res)
            this.tableData = [...res.data]
            this.total = res.data.length
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
        handleClick(){},
        handleSizeChange(val){
          this.limit=val
          this.page = 1
        },
        handleCurrentChange(val){
          this.page=val
        }
         
        }
      }
  

</script>

