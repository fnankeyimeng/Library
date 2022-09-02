<template>
    <div id="main">
        <el-form ref="ruleForm" :model="ruleForm" label-width="80px" >
            <el-form-item label="编号" prop="id">
                <el-input v-model="ruleForm.id"></el-input>
            </el-form-item>
            <el-form-item label="姓名">
                <el-input v-model="ruleForm.uname"></el-input>
            </el-form-item>
            <el-form-item label="密码" >
                <el-input v-model="ruleForm.upwd" show-password></el-input>
            </el-form-item>
            <el-form-item label="类型" >
                <template>
                    <el-radio v-model="ruleForm.type" label="1" disabled>管理员</el-radio>
                    <el-radio v-model="ruleForm.type" label="2">普通用户</el-radio>
                </template>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="tijiao()">确定</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "register",
        data(){
            return{
                ruleForm:[{
                    id:'',
                    uname:'',
                    upwd:'',
                    type:''
                }]
            }
        },methods:{
            tijiao:function () {
                let id = this.ruleForm.id;
                let uname = this.ruleForm.uname;
                let upwd = this.ruleForm.upwd;
                let type = this.ruleForm.type;
                this.$http.get("http://localhost:8081/user/addUser?id=" + id + "&uname=" + uname + "&upwd=" + upwd + "&type=" + type, {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                    if (req.data != null) {
                        alert("注册成功");
                        this.$router.push({name:"login"});

                    }
                })
            }
        }
    }
</script>

<style scoped>
    #main{
        margin: 0 auto;
        margin-left: 300px;
        width: 400px;
    }
</style>