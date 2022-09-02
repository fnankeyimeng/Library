<template>
    <div>
        <div>修改用户信息</div>
            <div id="main">
                <!-- model绑定model中得数据， rules属性传入约定得验证规则-->
                <el-form :model="ruleForm"  ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="编号" prop="id">
                        <el-input v-model="ruleForm.id" disabled></el-input>
                    </el-form-item>
                    <el-form-item label="姓名" prop="uname">
                        <el-input v-model="ruleForm.uname"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="upwd">
                        <el-input v-model="ruleForm.upwd"></el-input>
                    </el-form-item>
                    <el-form-item label="类型" prop="type">
                        <el-input v-model="ruleForm.type" disabled></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
</template>

<script>
    export default {
        name: "messOwn",
        data(){
            return{
                ruleForm: {
                    id:'',
                    uname:'',
                    upwd:'',
                    type:''
                }
            }
        },mounted(){

            let id=this.$store.state.userId;
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
                                    location.reload();
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