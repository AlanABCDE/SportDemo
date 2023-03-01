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
        <span class="span">Username :  user01</span>
        <span class="span">sex :  男</span>
        <span class="span">role : user  </span>
        <span class="span">email :  1@sports.com</span>
    </div>
  </el-card>
    </div>
</template>
<script lang="ts" setup>
import { reactive, toRefs } from 'vue'

const state = reactive({
  circleUrl:
    'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
})

const { circleUrl } = toRefs(state)
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