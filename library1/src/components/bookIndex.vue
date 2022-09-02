<template>
    <div>
        <div class="search-box">
            <el-input
                    placeholder="请输入图书名称"
                    v-model="inputVal"
                    clearable
                    size="small"
                    style="width: 500px"
            ></el-input>
            <el-button
                    icon="el-icon-search"
                    type="primary"
                    size="small"
                    v-on:click="searchbook"
                    style="margin: 0 10px 0 10px; height: 30px"
            ></el-button>
            <el-button
                    icon="el-icon-circle-plus-outline"
                    type="primary"
                    v-on:click="addbook"
                    style="margin: 0 10px 0 80px; height: 50px"
            ></el-button>

        </div>
        <div>
            <el-table :data="tableData" style="width: 100%">
                <el-table-column prop="bid" label="编号" width="150"></el-table-column>

                <el-table-column label="图片" width="150">
                    <template slot-scope="scope">
                        <img :src="require('../assets/img/'+scope.row.bpic)" style="width:100px;height: 100px">
                    </template>
                </el-table-column>

                <el-table-column prop="bname" label="书名" width="150" ></el-table-column>
                <el-table-column prop="bauthor" label="作者" width="150"></el-table-column>
                <el-table-column prop="status" label="状态" width="150"></el-table-column>
                <el-table-column  label="操作" width="180">
                    <template slot-scope="scope"><!--作用可以同各国scope绑定当前行得数据-->
                        <el-button v-on:click="delBook(scope.row.bid)" type="danger" icon="el-icon-delete"></el-button>
                        <el-button v-on:click="findById(scope.row.bid)" type="primary" icon="el-icon-edit"></el-button>
                    </template>
                </el-table-column>
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
        name: "bookIndex",
        data(){
            return{
                inputVal:'',
                tableData:[
                    {
                    bid:'',
                    bname:'',
                    bauthor:'',
                    status:'',
                    bpic:''
                }],

            }
        }, mounted(){
            this.$http.get("http://localhost:8081/book/findBook",{xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req=>{
                this.tableData=req.data.list;
            })
        },methods:{
            changePage:function (index) {
                this.$http.get("http://localhost:8081/book/findBook?index=" + index, {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                    this.tableData=req.data.list;
                })
            },searchbook:function () {
                let bookName=this.inputVal;
                this.$router.push({name:"searchBookMo",params:{bname:bookName}});
            },delBook:function (bid) {
                if (confirm("是否删除")) {
                    this.$http.get("http://localhost:8081/book/delBook?bid=" + bid, {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                        if(req.data!=null){
                            alert("删除成功");
                            location.reload();

                        }

                    })
                }
            },findById:function(bid){
                alert(bid);
                //将id传给修改页面，在修改页面进行显示，然后在修改
                this.$router.push({name:"updateBook",params:{bid:bid}});

            },addbook:function () {
                this.$router.push({name:"addBook"})
            }
        }
    }
</script>

<style scoped>

</style>