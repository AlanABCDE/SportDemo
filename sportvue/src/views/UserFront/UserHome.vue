<template>
    <h1>Welcome to HomePage</h1>
    <div>
        <div class="demo-image__lazy">
            <el-carousel indicator-position="outside">
    <el-carousel-item v-for="url in urls" :key="url">
        <img :src="url" class="el-carousel-item-img"/>
    </el-carousel-item>
  </el-carousel>
  </div>

        <div style="margin:auto;width:90%">
            <el-row :gutter="12">
                <el-col :span="8">
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span>新闻</span>
                            <el-button style="float: right; padding: 3px 0" type="text">更多</el-button>
                        </div>
                        <div v-for="o in 4" :key="o" class="text item">
                            <div style="width:100px">
                                {{ '一条新闻 ' + o }}
                            </div>

                        </div>
                    </el-card>
                </el-col>
                <el-col :span="8">
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span>活动</span>
                            <el-button style="float: right; padding: 3px 0" type="text">更多</el-button>
                        </div>
                        <div v-for="o in 4" :key="o" class="text item" width="">
                            {{ '一条活动 ' + o }}
                        </div>
                    </el-card>
                </el-col>
                <el-col :span="8">
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span>公告</span>
                            <el-button style="float: right; padding: 3px 0" type="text">更多</el-button>
                        </div>
                        <div v-for="o in 4" :key="o" class="text item">
                            {{ '一条公告 ' + o }}
                        </div>
                    </el-card>
                </el-col>
            </el-row>
        </div>



    </div>
</template>
<script lang="ts" setup>

const urls=[
  'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
  'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg',
  'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
  'https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg',
]
</script>
<style>
.text {
    font-size: 14px;
}

.item {
    margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
    display: table;
    content: "";
}

.clearfix:after {
    clear: both
}

.box-card {
    width: 450px;
}

.el-card__body {
    width: 100px;
}

.el-carousel-item-img{
    height: 100%;
}
</style>