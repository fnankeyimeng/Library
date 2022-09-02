<template>
    <div>
        <div>修改用户信息</div>
         <div id="main">
        <!-- model绑定model中得数据， rules属性传入约定得验证规则-->
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="编号" prop="id">
                <el-input v-model="ruleForm.id"></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="uname">
                <el-input v-model="ruleForm.uname"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="upwd">
                <el-input v-model="ruleForm.upwd"></el-input>
            </el-form-item>
            <el-form-item label="类型" prop="type">
                <el-input v-model="ruleForm.type" ></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
                <el-button type="danger" @click="quxiao()">取消</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
         </div>
    </div>
</template>

<script>
    export default {
        name: "updateUser",
        data(){
            return{
                ruleForm: {
                    id:'',
                    uname:'',
                    upwd:'',
                    type:''
                }, rules: {
                    uname: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                        {min: 1, max: 5, message: '长度在 1 到 5 个字符', trigger: 'blur'}
                    ],
                    upwd: [
                        {required: true, message: '请输入密码', trigger: 'blur'},
                        {min: 1, max: 5, message: '长度在 1 到 5 个字符', trigger: 'blur'}
                    ]
                }

            }
        },mounted(){
            let id=this.$route.params.id;
            //根据Id查询对象
            this.$http.get("http://localhost:8081/user/findById?id="+id).then(req=>{
                this.ruleForm.id=req.data.id;
                this.ruleForm.uname=req.data.uname;
                this.ruleForm.upwd=req.data.upwd;
                this.ruleForm.type=req.data.type;

            })

        },methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        if (confirm("是否修改")) {
                            let id = this.ruleForm.id;
                            let uname = this.ruleForm.uname;
                            let upwd = this.ruleForm.upwd;
                            let type = this.ruleForm.type;
                            this.$http.get("http://localhost:8081/user/updateUser?id=" + id + "&uname=" + uname + "&upwd=" + upwd + "&type=" + type, {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                                if (req.data == true) {
                                    alert("修改成功");
                                    this.$router.push({name: "userIndex"});
                                } else {
                                    alert("修改失败")
                                }
                            })
                        }

                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }, quxiao:function () {
            this.$router.push({name:"userIndex"});
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