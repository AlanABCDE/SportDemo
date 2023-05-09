<template>
    <div class="body">
        <h1>小队查询</h1>
        <div class="search">
            <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="selteamName"></el-input>
            <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
            <el-button type="warning" @click="reset">重置</el-button>
        </div>
        <el-table :data="tableData.slice((page - 1) * limit, page * limit)" style="width: 100%;height: 300px;">
            
            
            <el-table-column prop="teamName" label="小队名称" width="180" />
            <el-table-column prop="username" label="小队成员" width="180" />
            <el-table-column prop="classNo" label="所属班级" />
        </el-table>

        <el-pagination :current-page="page" :page-size="limit" :page-sizes="[5, 10, 15, 20]" background
    layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
    @current-change="handleCurrentChange" />

    </div>
</template>
<script>
import axios from 'axios';
export default{
    data() {
        return {
            tableData: [],
            selteamName:'',
            page: 1,
            limit: 5,
            total: 0
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
                this.total = res.data.data.length
            })
        },
        reset() {
            this.selteamName=''
            //this.load()
        },
        handleSizeChange(val) {
            this.limit = val
            this.page = 1
        },
         handleCurrentChange(val) {
            this.page = val
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