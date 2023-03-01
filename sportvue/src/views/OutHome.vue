<template >
  <h1>Campus Sports Event Management Website</h1>
  <div class="wapper">
  <el-button type="primary" @click="goLog">Login</el-button>
  <el-button type="primary" @click="goReg">Register</el-button>
  <el-button type="primary" @click="goUserHome">UserHome</el-button>
  <el-button type="primary" @click="test">test</el-button>
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
}
</style>