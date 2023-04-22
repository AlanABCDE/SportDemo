<template>
    <div class="box">
    <h1>欢迎使用校园体育赛事管理平台</h1>
    <div>
        <div class="demo-image__lazy">
            <el-carousel indicator-position="outside">
                <el-carousel-item v-for="url in urls" :key="url">
                    <img :src="url" class="el-carousel-item-img" />
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
                        <div class="text item">
                            <div style="width:200px">
                                <el-link href="https://element.eleme.io" target="_blank">喜迎二十大</el-link>
                                <el-link href="https://element.eleme.io" target="_blank">恭喜阿根廷世界杯夺冠</el-link>
                                <el-link href="https://element.eleme.io" target="_blank">奋力开创体育强国建设新局面</el-link>
                                <el-link href="https://element.eleme.io" target="_blank">少年强则国强</el-link>
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
                        <div class="text item">
                            <div style="width:200px">
                                <el-link   href="https://element.eleme.io" target="_blank">基沃托斯光轮大赛正式开幕</el-link>
                                <el-link   href="https://element.eleme.io" target="_blank">FIFA World Cup大赛正式开幕</el-link>
                                <el-link   href="https://element.eleme.io" target="_blank">CBA正式开幕</el-link>
                                <el-link   href="https://element.eleme.io" target="_blank">NBA季后赛赛正式开幕</el-link>
                            </div>
                        </div>
                    </el-card>
                </el-col>
                <el-col :span="8">
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span>公告</span>
                            <el-button style="float: right; padding: 3px 0" type="text">更多</el-button>
                        </div>
                        <div class="text item">
                            <div style="width:200px">
                                <el-link href="https://element.eleme.io" target="_blank">关于平台开始试运行的一则公告</el-link>
                                <el-link href="https://element.eleme.io" target="_blank">关于平台现存漏洞的一则公告</el-link>
                                <el-link href="https://element.eleme.io" target="_blank">关于平台开始维护的一则公告</el-link>
                                <el-link href="https://element.eleme.io" target="_blank">关于平台的版权声明的一则公告</el-link>
                            </div>
                        </div>
                    </el-card>
                </el-col>
            </el-row>
        </div>

    </div>
</div>
</template>
<script lang="ts" setup>

const urls = [
    'https://cdn4.eyeem.com/thumb/b62716d62756471677a3a3a313236323031363837363634313d223235346332356336316031616669366338313039356236653332693163343935373163343661653a3a3a3/1100/1100',
    'https://ts1.cn.mm.bing.net/th/id/R-C.010f83b74aa0e87c53bac1e885fa8434?rik=ugeClDWr3GRdeg&riu=http%3a%2f%2fpic.zsucai.com%2ffiles%2f2013%2f0718%2ftycx8.jpg&ehk=suCZTMpGpy01JZCjblUW%2btsTQC0p6xeE8%2ftRKmvdTBI%3d&risl=&pid=ImgRaw&r=0',
    'https://png.pngtree.com/back_origin_pic/04/04/20/af56207b880b599795a67ef59c434c26.jpg',
    'https://cdn4.eyeem.com/thumb/b62716d62756471677a3a3a353132323238323033303835313d283232393234356262323231633832326638333666353165336260383331373135643430303466616a3a3a3/1100/1100',
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

.el-carousel-item-img {
    height: 100%;
}

</style>