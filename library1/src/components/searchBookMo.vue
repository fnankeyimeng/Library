<template>
    <div>
        <div>
            <el-table :data="tableData" style="width: 100%">
                <el-table-column prop="bid" label="编号" width="150"></el-table-column>
                <el-table-column width="150" label="图片">
                    <template slot-scope="scope">
                        <img :src="require('../assets/img/'+scope.row.bpic)" style="width:100px;height: 100px">
                    </template>
                </el-table-column>
                <el-table-column prop="bname" label="书名" width="150" ></el-table-column>
                <el-table-column prop="bauthor" label="作者" width="150"></el-table-column>
                <el-table-column prop="status" label="状态" width="150"></el-table-column>

            </el-table>
        </div>
        <div id="page">
            <el-pagination
                    background @current-change="changePage" layout="prev, pager, next" :total="60">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    export default {
        name: "searchBookMo",
        data(){
            return {
                tableData: [{
                    bid: '',
                    bname: '',
                    bauthor: '',
                    status: '',
                    bpic: ''
                }]
            }
        },mounted(){
            let bname=this.$route.params.bname;
            this.$http.get("http://localhost:8081/book/findBookMo?bname=" + bname, {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                this.tableData = req.data.list;
             })
        },methods:{
            changePage:function (index) {
                let  bname=this.$route.params.bname;
                this.$http.get("http://localhost:8081/book/findBookMo?index=" + index+"&bname="+bname, {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                    this.tableData=req.data.list;
                })
            }
        }
    }
</script>

<style scoped>

</style>