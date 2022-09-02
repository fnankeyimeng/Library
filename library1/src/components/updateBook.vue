<template>
    <div id="main">
        <!-- model绑定model中得数据， rules属性传入约定得验证规则-->
        <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="编号" prop="bid">
                <el-input v-model="ruleForm.bid"></el-input>
            </el-form-item>
            <el-form-item label="图书名" prop="bname">
                <el-input v-model="ruleForm.bname"></el-input>
            </el-form-item>
            <el-form-item label="作者" prop="bauthor">
                <el-input v-model="ruleForm.bauthor"></el-input>
            </el-form-item>
            <el-form-item label="状态" prop="status">
                <template>
                    <el-radio v-model="ruleForm.status" label="未借">未借</el-radio>
                    <el-radio v-model="ruleForm.status" label="已借">已借</el-radio>
                </template>

            </el-form-item>
            <el-form-item label="商品图片">
                <el-upload class="avatar-uploader" action="http://localhost:8081/upload/upload" :show-file-list="false" :on-success="handleAvatarSuccess">
                    <img v-if="imageUrl" :src="imageUrl" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
                <el-button type="danger" @click="quxiao()">取消</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "updateBook",
        data() {
            return {
                ruleForm: {
                    bid: '',
                    bname: '',
                    bauthor: '',
                    status: '',
                    bpic: ''
                },
            }
        },mounted(){
            let bid=this.$route.params.bid;
            alert(bid)
            this.$http.get("http://localhost:8081/book/findByBookId?bid=" + bid,{xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req=> {
                this.ruleForm.bid = req.data.bid;
                this.ruleForm.bname = req.data.bname;
                this.ruleForm.bauthor = req.data.bauthor;
                this.ruleForm.status=req.data.status;
                this.ruleForm.bpic=req.data.bpic;
            })
        },methods:{
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        if(confirm("是否修改")){

                            let bid=this.ruleForm.bid;
                            let bname=this.ruleForm.bname;
                            let bauthor=this.ruleForm.bauthor;
                            let status=this.ruleForm.status;
                            let bpic=this.ruleForm.bpic;
                            this.$http.get("http://localhost:8081/book/updateBook?bid=" + bid+"&bname="+bname+"&bauthor="+bauthor+"&status="+status+"&bpic="+bpic,{xhrFields: {withCredentials: true}},{crossDomain: true}).then(req=>{
                                if (req.data == true) {
                                    alert("修改成功");
                                    this.$router.push({name:"bookIndex"});
                                }else{
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
            },  quxiao:function () {
                this.$router.push({name:"bookIndex"});
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