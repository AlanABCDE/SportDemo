<template>
    <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="uid" label="编号" width="180" />
      <el-table-column prop="username" label="名字" width="180" />
      <el-table-column prop="password" label="密码" width="180" />
      <el-table-column prop="sex" label="性别" width="180" />
      <el-table-column prop="role" label="角色" width="180" />
      <el-table-column prop="email" label="邮件" />
    </el-table>
  </template>
  
<script >
import  axios from 'axios';
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
            }
        },
        created() {
            const  _this=this
            axios.get("http://localhost:9090/user/getUser").then(function(res){
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
    }

</script>
  