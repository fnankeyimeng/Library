<template>
    <div id="main">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleFrom">
            <el-form-item label ="用户名" prop="uname">
                <el-input v-model="ruleForm.uname" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label ="密码" prop="upwd">
                <el-input v-model="ruleForm.upwd" placeholder="请输入密码" show-password></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
                <el-button @click="resetForm"> 注册</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: `login`,
        data(){
            return{
                ruleForm:{
                    uname:'',
                    upwd:''
                },rules:{
                    uname:[
                        {required:true,message:'请输入用户名',trigger:'blur'},
                        {min:2,max:5,message: '长度在 2 到 5 个字符',trigger:'blur'}
                    ],upwd:[
                        {required:true,message:'请输入密码',trigger:'blur'},
                        {min:3,max:5,message: '长度在 3 到 5 个字符',trigger:'blur'}
                    ]
                }
            }
        }, methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let uname=this.ruleForm.uname;
                        let upwd=this.ruleForm.upwd;
                        this.$http.get("http://localhost:8081/user/login?uname="+uname+"&upwd="+upwd).then(req=>{

                            this.$store.commit('userInfo',req.data.id);
                            this.$store.commit('userInfo1',req.data.uname);
                            //将数据存贮在sessionStorage中，页面刷新数据不会消失
                            sessionStorage.setItem("uname",this.ruleForm.uname);
                            //跳转页面
                            if(req.data.type===1){
                                this.$router.push({name:"userIndex"});
                            }else if(req.data.type===2){
                                this.$router.push({name:"booklend"});
                            }

                        })

                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm:function () {
              this.$router.push({name:"register"})
            }
        }
    }
</script>

<style scoped>
    #main{
        margin:0 auto;
        width: 400px;
        height: 400px;
        margin-top: 100px;
    }
</style>