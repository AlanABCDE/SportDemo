<template >
  <h1>Campus Sports Event Management Website</h1>
  <div class="wapper">
  <el-button type="primary" @click="goLog">Login</el-button>
  <el-button type="primary" @click="goReg">Register</el-button>
  <el-button type="primary" @click="goUserHome">UserHome</el-button>
  <el-button type="primary" @click="test">test</el-button>
  <img class="img" url="https://gitee.com/alanabcde/SportDemo/raw/main/sportvue/src/assets/QRCode.png" />
</div>
</template>
<script>
// import {useRouter} from 'vue-router'
export default{
  methods: {
  goLog(){
    const _this = this;
    _this.$router.push('/login');
  },
  goReg(){
    const _this = this;
    _this.$router.push('/register');
  },
  goUserHome(){
    const _this = this;
    _this.$router.push('/userfront/userhome');
  },
  test(){
    const _this = this;
    _this.$router.push('/test');
  },
}
}

</script>
<style>
.wapper {
  background-color:  #d9ecff;
  width: 750px;
  height: 500px;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  text-align: center;
  left: 500px;
}
.img{
  width: 200px;
  height: 200px;
}

</style>