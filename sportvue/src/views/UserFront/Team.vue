<template>
    <div class="body">
        <div class="search">
            <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="selteamName"></el-input>
            <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
            <el-button type="warning" @click="reset">重置</el-button>
        </div>
        <el-table :data="tableData" style="width: 100%;height: 300px;">
            
            <el-table-column prop="teamId" label="teamId" width="180" />
            <el-table-column prop="teamName" label="teamName" width="180" />
            <el-table-column prop="username" label="username" width="180" />
            <el-table-column prop="classNo" label="classNo" />
        </el-table>
    </div>
</template>
<script>
import axios from 'axios';


export default {
    data() {
        return {
            tableData: [],
            selteamName:''
        }
    },
    created() {
    },
    methods: {
        load(){
            axios.get("http://localhost:9090/team/selTeam/"+this.selteamName,{
            })
            .then(res => {
                console.log(JSON.stringify(res.data.data))
                this.tableData=res.data.data
                console.log("-------------------------------")
                console.log(JSON.stringify(this.tableData.data))
            })
        },
        reset() {
            this.selteamName=''
            //this.load()
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