<template >
  <div class="back">
  <h1 class="fadein">欢迎使用体育赛事管理网站</h1>
  <div class="wapper">
  <el-button type="primary" @click="goLog">得先登录</el-button>
  <el-button type="primary" @click="goReg">还没注册?</el-button>
  <el-button type="primary" @click="goUserHome">我就看看</el-button>
  <el-button type="primary" @click="test">权</el-button>
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

.fadein {
  opacity: 1;
  transition: opacity 1s;
}
.wapper {
  /* width: 750px;
  height: 500px;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  text-align: center;
  left: 500px; */
}
.back{
  background-image: url('E:\Code\Driving\SportDemo\sportvue\src\assets\index\94830716_p0.png');
  background-size:100% 100%;
  width: 100%;
    position: absolute;
    height:100%
}


</style>