<template >
  <div class="back">
    <h1 class="fadein">欢迎使用体育赛事管理网站</h1>
    <div class="wapper">
      <el-button type="primary" @click="goUserHome">我就看看</el-button>
      <el-button type="primary" @click="test">权</el-button>
      <el-button type="primary" @click="goLog">得先登录</el-button>
      <el-button type="primary" @click="goReg">还没注册?</el-button>
    </div>
    <el-image :src="src" class="img">
      <div slot="placeholder" class="image-slot">
        加载中<span class="dot">...</span>
      </div>
    </el-image>
  </div>
</template>
<script>
// import {useRouter} from 'vue-router'
export default {
  data() {
    return {
      src: 'https://preview.qiantucdn.com/58pic/43/94/22/42c58PICK9I4DevprV7ff_PIC2018.png%21w1024_new_0'
    }
  },
  methods: {
    goLog() {
      const _this = this;
      _this.$router.push('/login');
    },
    goReg() {
      const _this = this;
      _this.$router.push('/register');
    },
    goUserHome() {
      const _this = this;
      _this.$router.push('/guestfront/guesthome');
    },
    test() {
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
  margin: -5% 0 0 75%;
}

.back {
  background-image: url('E:\Code\Driving\SportDemo\sportvue\src\assets\index\94830716_p0.png');
  background-size: 100% 100%;
  width: 100%;
  position: absolute;
  height: 100%
}

.img {
  margin: 5% 55% 0 0;
  width: 500px;

}
</style>