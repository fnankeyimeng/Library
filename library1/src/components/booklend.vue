<template>
    <div>
            <div class="searchBook">
                <el-input
                        placeholder="请输入图书名称"
                        v-model="inputbook"
                        clearable
                        size="small"
                        style="width: 500px"
                ></el-input>
                <el-button
                        icon="el-icon-search"
                        type="primary"
                        size="small"
                        v-on:click="searchbookName"
                        style="margin: 0 20px 20px 10px; height: 30px"
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
                            <el-button v-if="scope.row.status == '未借'" v-on:click="lendBook(scope.row.bid)" type="primary">借书</el-button>
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
        name: "booklend",
        data() {
            return {
                inputbook: '',
                tableData: [
                    {
                        bid: '',
                        bname: '',
                        bauthor: '',
                        status: '',
                        bpic: ''
                    }],

            }
        }, mounted() {
            this.$http.get("http://localhost:8081/book/findBook", {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                this.tableData = req.data.list;
            })
        }, methods: {
            changePage: function (index) {
                this.$http.get("http://localhost:8081/book/findBook?index=" + index, {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                    this.tableData = req.data.list;
                })
            }, searchbookName: function () {
                let name = this.inputbook;
                this.$router.push({name: "searchBook", params: {bname: name}});
            },lendBook:function (bid) {
                this.$router.push({name: "addLend", params: {bid: bid}});
            }
        }
    }
</script>

<style scoped>

</style>