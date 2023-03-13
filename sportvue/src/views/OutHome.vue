<template >
  <div class="back">
  <h1>Campus Sports Event Management Website</h1>
  <div class="wapper">
  <el-button type="primary" @click="goLog">Login</el-button>
  <el-button type="primary" @click="goReg">Register</el-button>
  <el-button type="primary" @click="goUserHome">UserHome</el-button>
  <el-button type="primary" @click="test">test</el-button>
  </div>
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
    _this.$router.push('/adminfront/adminhome');
  },
}
}

</script>
<style>
.wapper {
  width: 750px;
  height: 500px;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  text-align: center;
  left: 500px;
}
.back{
  background-image: url('E:\Code\Driving\SportDemo\sportvue\src\assets\index\94830716_p0.png');
  background-size:100% 100%;
  width: 100%;
    position: absolute;
    height:100%
}

</style>