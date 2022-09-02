<template>
    <el-container class="index-container">
        <!--头部-->
        <el-header>
            <div class="head-logo">
                <!-- <img src="../assets/img/2020-07-17_162648.jpg">-->
                <span>图书借阅中心</span>
            </div>
            <div class="head-button">
                <span>{{id}}</span>
                <span>{{uname}}</span>
                <el-button type="info" @click="loginOut">退出</el-button></div>
        </el-header>


        <!--页面主体区域-->
        <el-container>
            <!--页面左侧区域-->
            <el-aside width="200px">
                <!--侧边栏菜单区域-->
                <el-menu
                        background-color="#333744"
                        text-color="#fff"
                        active-text-color="#409eff"
                        :router="true"><!--二级菜单颜色,unique-opened菜单只打开一个.:router="true":开启菜单路由模式-->
                    <!--一级菜单-->
                    <el-submenu index="1">
                        <!--一级菜单模板区-->
                        <template slot="title">
                            <!--图标-->
                            <i class="el-icon-user"></i>
                            <!--文本-->
                            <span>图书信息</span>
                        </template>
                        <!--二级菜单-->
                        <!--index对应要跳转到的视图-->
                        <el-menu-item index="booklend">
                            <template slot="title">
                                <!--图标-->
                                <i class="el-icon-menu"></i><!--二级菜单图标-->
                                <!--文本-->
                                <span>借书</span>
                            </template>
                        </el-menu-item>

                    </el-submenu>

                </el-menu>


                <!--侧边栏菜单区域-->
                <el-menu
                        background-color="#333744"
                        text-color="#fff"
                        active-text-color="#409eff"
                        :router="true">
                    <!--一级菜单-->
                    <el-submenu index="1">
                        <!--一级菜单模板区-->
                        <template slot="title">
                            <!--图标-->
                            <i class="el-icon-location"></i>
                            <!--文本-->
                            <span>借书记录</span>
                        </template>
                        <!--二级菜单-->
                        <el-menu-item index="lendList">
                            <template slot="title">
                                <!--图标-->
                                <i class="el-icon-menu"></i>
                                <!--文本-->
                                <span>详细记录</span>
                            </template>
                        </el-menu-item>
                    </el-submenu>
                </el-menu>



                <!--侧边栏菜单区域-->
                <el-menu
                        background-color="#333744"
                        text-color="#fff"
                        active-text-color="#409eff"
                        :router="true">
                    <!--一级菜单-->
                    <el-submenu index="1">
                        <!--一级菜单模板区-->
                        <template slot="title">
                            <!--图标-->
                            <i class="el-icon-location"></i>
                            <!--文本-->
                            <span>个人信息</span>
                        </template>
                        <!--二级菜单-->
                        <el-menu-item index="messOwn">
                            <template slot="title">
                                <!--图标-->
                                <i class="el-icon-menu"></i>
                                <!--文本-->
                                <span>详细</span>
                            </template>
                        </el-menu-item>
                    </el-submenu>
                </el-menu>



            </el-aside>


            <!--页面右侧区域-->
            <el-main>
                <!--路由的占位符-->
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>


</template>


<script>
    export default {
        name: "bookAll",
        data(){
            return{
                id:'',
                uname:''
            }
        },mounted(){
            this.uname=this.$store.state.uname;
            this.id=this.$store.state.userId;
        },
        methods:{
            loginOut:function () {
                this.$router.push({name:"login"})
            }
        }
    }
</script>

<style scoped>
    .index-container{
        height: 750px;
        margin-top: -60px;
    }
    .el-header{
        background-color: #373d41;
        display: flex;
        justify-content: space-between;
        padding-left: 0;
        align-items: center;
        color:#fff;

    }
    span{
        margin-left: 20px;
    }
    .head-logo{
        display: flex;
        align-items: center;

    }
    .font-left{
        font-size: 20px;
        color: white;
        font-weight: bolder;
        margin-left: -920px;
        margin-top: 10px;
    }
    .head-button{
        margin-left: 800px;
        margin-top: -20px;
    }
    .el-aside{
        background-color: #333744;
    }
    .el-main{
        background-color: #eaedf1;
    }
</style>