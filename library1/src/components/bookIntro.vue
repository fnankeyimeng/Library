<template>
    <div id="main">
        <!-- model绑定model中得数据， rules属性传入约定得验证规则-->
        <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="图片" prop="bpic">
                <template >
                    <img :src="require('../assets/img/'+ruleForm.bpic)" style="width:100px;height: 100px">
                </template>
            </el-form-item>
            <el-form-item label="编号" prop="bid">
                <el-input v-model="ruleForm.bid" :disabled="true"></el-input>
            </el-form-item>

            <el-form-item label="图书名" prop="bname">
                <el-input v-model="ruleForm.bname" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="作者" prop="bauthor">
                <el-input v-model="ruleForm.bauthor" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="状态" prop="status">
                <el-input v-model="ruleForm.status" :disabled="true"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button v-on:click="deleteList" type="primary">还书</el-button>
            </el-form-item>

        </el-form>
    </div>
</template>

<script>
    export default {
        name: "bookIntro",
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
            let bid=this.$route.query.id;
            this.$http.get("http://localhost:8081/book/findByBookId?bid=" + bid,{xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req=> {
                this.ruleForm.bid = req.data.bid;
                this.ruleForm.bname = req.data.bname;
                this.ruleForm.bauthor = req.data.bauthor;
                this.ruleForm.status=req.data.status;
                this.ruleForm.bpic=req.data.bpic;
            })
        }, methods: {
            deleteList: function () {
                if (confirm("是否还书")) {
                    let b_id=this.ruleForm.bid;
                    this.$http.get("http://localhost:8081/yding/delYD?b_id=" + b_id, {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                        if (req.data != null) {
                            alert("还书成功");
                            this.$router.push({name:"lendList"})

                        }

                    })
                }
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