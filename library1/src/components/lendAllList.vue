<template>
    <div>
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="yid" label="编号" width="150"></el-table-column>
            <el-table-column prop="ystarttime" label="开始时间" width="150" ></el-table-column>
            <el-table-column prop="yendtime" label="结束时间" width="150"></el-table-column>
            <el-table-column prop="u_id" label="借书人" width="150"></el-table-column>
            <el-table-column prop="b_id" label="书名" width="150" >
                <template slot-scope="scope"><!--作用可以同各国scope绑定当前行得数据-->
                    <router-link :to="{name:'bookIntro',query:{id:scope.row.b_id}}">点击显示{{ scope.row.b_id}}号图书信息</router-link>
                </template>
            </el-table-column>

            <el-table-column prop="status" label="状态" width="150"></el-table-column>
            <el-table-column  label="操作" width="180">
                <template slot-scope="scope"><!--作用可以同各国scope绑定当前行得数据-->
                    <el-button v-on:click="deleteList(scope.row.b_id)" type="primary">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "lendAllList",
        data() {
            return {
                tableData: [{
                    yid: '',
                    ystarttime: '',
                    yendtime: '',
                    u_id: '',
                    b_id:'',
                    status: ''
                }]

            }
        }, mounted() {
            this.$http.get("http://localhost:8081/yding/findAllYD", {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                this.tableData = req.data.list;
            })
        }, methods: {
            deleteList: function (b_id) {
                if (confirm("是否删除")) {
                    this.$http.get("http://localhost:8081/yding/delYD?b_id=" + b_id, {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                        if (req.data != null) {
                            alert("删除成功");
                            location.reload();

                        }

                    })
                }
            }
        }
    }

</script>

<style scoped>

</style>