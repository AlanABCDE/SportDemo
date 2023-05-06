<template>
    <h1>PersonalMainPage</h1>
    <div class="block">
          <el-avatar :size="50" :src="circleUrl" />
        </div>
    <div class="card">
        <el-card class="box-card">
    <template #header>
      <div class="card-header">
        <span>About Me</span>
        <el-button class="button" text>Edit</el-button>
      </div>
    </template>
    <div>
        <span class="span">Username :  {{ user.username }}</span>
        <span class="span">sex :  {{ user.sex }}</span>
        <span class="span">role : {{ user.role }}</span>
        <span class="span">email :  {{ user.token }}</span>
    </div>
  </el-card>
    </div>
</template>
<script>
export default{
    name: "UserMsg",
    data(){
        return {
            user : localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
        }
    },
    created(){

    },
    methods:{
    }
}
</script>
<style>
.el-card__body {
    width: 420px;
}
.card {
    padding: 2em;
    width: 476px;
    position: relative;
    left: 676px;
}
.span{
    width: 100%;
    display: flex;
}
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.box-card {
  width: 480px;
}
</style>