<template>
    <div class="body">
        <div class="search">
            <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="selteamName"></el-input>
            <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
            <el-button type="warning" @click="reset">重置</el-button>
        </div>
        <el-table :data="tableData" border style="width: 100%;">
            <el-table-column prop="teamId" label="小队编号" width="180" align:center/>
            <el-table-column prop="teamName" label="小队" width="180" />
            <el-table-column prop="username" label="成员" width="180" />
            <el-table-column prop="classNo" label="所属班级" align="center"/>
        </el-table>
    </div>
</template>
<script>
import axios from 'axios';


export default {
    data() {
        return {
            tableData: [
                {
                  teamId:'',
                  teamName:'',
                  username:'',
                  classNo:''
                }
            ],
            selteamName:" "
        }
    },
    created() {

    },
    methods: {
        load(){
            axios.get("http://localhost:9090/team/selTeam/"+this.selteamName,{
            })
            .then(res => {
                console.log(res)
                this.tableData=res.data
                console.log(this.tableData)
            })
        },
        reset() {
      this.selteamName=''
      this.load()
    },
    }
}
</script>
<style>
.body{
    width: 1000px; 
    margin: 0px auto;
    height: 700px;
}
.search {
    margin: 100px 0;
}
</style>