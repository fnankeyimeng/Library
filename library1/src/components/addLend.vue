<template>
    <div id="add">

        <el-form ref="ruleForm" :model="ruleForm" label-width="80px" class="demo-ruleForm" >
            <el-form-item label="图书编号">
                <el-input v-model="ruleForm.b_id" ></el-input>
            </el-form-item>
            <el-form-item label="图书名字">
                <el-input v-model="ruleForm.bname"></el-input>
            </el-form-item>

            <el-form-item label="用户Id">
                <el-input v-model="ruleForm.u_id"></el-input>
            </el-form-item>
            <el-form-item label="用户名">
                <el-input v-model="ruleForm.uname"></el-input>
            </el-form-item>
            <el-form-item label="起始时间">
                <el-date-picker
                        v-model="ruleForm.ystarttime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="借书日期"
                        @change="dateFormat">
                </el-date-picker>
                <!--<el-input v-model="ruleForm.ystarttime"></el-input>-->
            </el-form-item>
            <el-form-item label="结束时间">
                <el-date-picker
                        v-model="ruleForm.yendtime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="还书日期">
                </el-date-picker>
                <!--<el-input v-model="ruleForm.yendtime"></el-input>-->
            </el-form-item>
            <el-form-item label="状态">
                <template>
                    <el-radio v-model="ruleForm.status" label="未借" disabled>未借</el-radio>
                    <el-radio v-model="ruleForm.status" label="已借">已借</el-radio>
                </template>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="queding()">确定</el-button>
                <el-button type="danger" @click="quxiao()">取消</el-button>
            </el-form-item>

        </el-form>
    </div>
</template>
<script>
    export default {
        name: "addLend",
        data(){
            return{
                ruleForm:{
                    b_id:'',
                    bname:'',
                    status:'',
                    u_id:'',
                    ystarttime:'',
                    yendtime:'',
                }
            }
        }, mounted(){
            this.ruleForm.u_id=this.$store.state.userId;
            this.ruleForm.uname=this.$store.state.uname;
            let bid=this.$route.params.bid;
            this.$http.get("http://localhost:8081/book/findByBookId?bid=" + bid).then(req=> {
                this.ruleForm.b_id = req.data.bid;
                this.ruleForm.bname = req.data.bname;
                this.ruleForm.status=req.data.status;
            })
        },methods:{

            queding:function () {
                let ystarttime=this.ruleForm.ystarttime.toString();
                let yendtime=this.ruleForm.yendtime.toString();
                let u_id=this.ruleForm.u_id;
                let b_id=this.ruleForm.b_id;
                let status=this.ruleForm.status;
                this.$http.get("http://localhost:8081/yding/addyd?u_id=" + u_id +" &b_id=" + b_id + "&ystarttime=" + ystarttime + "&yendtime=" + yendtime + "&status=" +status,
                    {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                    if(req.data!=null){
                        alert("借书成功，请到借书记录中查看");
                        this.$router.push({name:"booklend"});
                    }
                })
            },
            quxiao:function () {
                this.$router.push({name:"booklend"});
            }
        }
    }
</script>


<style scoped>
    #add{
        margin: 0 auto;
        width: 400px;
        margin-left: 400px;
    }

</style>