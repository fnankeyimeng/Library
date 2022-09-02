<template>
    <div id="main">
        <el-form ref="ruleForm" :model="ruleForm" label-width="80px" >
            <el-form-item label="图书编号" prop="bid">
                <el-input v-model="ruleForm.bid"></el-input>
            </el-form-item>
            <el-form-item label="图书名字">
                <el-input v-model="ruleForm.bname"></el-input>
            </el-form-item>
            <el-form-item label="作者">
                <el-input v-model="ruleForm.bauthor"></el-input>
            </el-form-item>
            <el-form-item label="状态">
                <template>
                    <el-radio v-model="ruleForm.status" label="未借" >未借</el-radio>
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
                <el-button type="primary" @click="tijiao()">确定</el-button>
                <el-button type="danger" @click="quxiao()">取消</el-button>
            </el-form-item>
        </el-form>


    </div>
</template>

<script>
    export default {
        name: "addBook",
        data(){
            return{
                imageUrl:'',
                ruleForm:{
                    bid:'',
                    bname:'',
                    bauthor:'',
                    status:'',
                    bpic:''
                }
            }
        },methods:{
            tijiao:function () {
                let bid=this.ruleForm.bid;
                let bname=this.ruleForm.bname;
                let bauthor=this.ruleForm.bauthor;
                let status=this.ruleForm.status;
                let bpic=this.ruleForm.bpic;
                this.$http.get("http://localhost:8081/book/addBook?bid="+bid+"&bname="+bname+"&bauthor="+bauthor+"&status="+status+"&bpic="+bpic).then(req=>{
                    if(req.data!=null){
                        alert("添加成功");
                        this.$router.push({name:"bookIndex"});
                    }
                })
            },
            handleAvatarSuccess(res, file) {

                this.ruleForm.bpic= res;//从后台获取filename给path赋值
                this.imageUrl = URL.createObjectURL(file.raw);

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