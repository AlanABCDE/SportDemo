<template>
    <div class="background">
    <h1>欢迎使用校园赛事管理网站-管理端</h1>
    <div class="block">
        <span class="wel">欢迎你，{{ user.username }} : </span>
        <span> 接下来想干点什么？</span>
    </div>
    <div>
        
    </div>
    </div>
</template>
<script>

export default{
    name: "Front",
    data(){
        return {
            user : localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
        }
    }
}
</script>

<style>
.background {
    height: 1000px;
    width: 100%;
    
}
.wel{
    margin:  0 0 0 0;
}
.block{
    margin: 200px auto;  width: 350px; height: 25px; padding: 20px; border-radius: 10px;
    background-color: rgba(236,239,247, 0.78);
    border:100px;
}
</style>