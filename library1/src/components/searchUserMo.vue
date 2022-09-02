<template>
    <div>
    <div id="ta">
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="id" label="编号" width="180">
            </el-table-column>
            <el-table-column prop="uname" label="用户名" width="180">
            </el-table-column>
            <el-table-column prop="upwd" label="密码" width="180">
            </el-table-column>
            <el-table-column prop="type" label="类型" width="180">
            </el-table-column>
            <el-table-column  label="操作" width="180">
                <template slot-scope="scope"><!--作用可以同各国scope绑定当前行得数据-->
                    <el-button v-on:click="delUser(scope.row.id)" type="danger" icon="el-icon-delete"></el-button>
                    <el-button v-on:click="findById(scope.row.id)" type="primary" icon="el-icon-edit"></el-button>
                </template>
            </el-table-column>

        </el-table>
    </div>
    <div id="page">
        <el-pagination
                background
                @current-change="changePage"
                layout="prev, pager, next"
                :total="60">
        </el-pagination>
    </div>
    </div>
</template>

<script>
    export default {
        name: "searchUserMo",
        data(){
            return{
                tableData: [
                    {
                        id:'',
                        uname:'',
                        upwd:'',
                        type:''
                    }
                ]
            }
        },mounted(){
            let uname=this.$route.params.name;
            this.$http.get("http://localhost:8081/user/findUserMo?uname=" + uname, {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                this.tableData = req.data.list;
            })
        },methods:{
            changePage:function (index) {
                let  uname=this.$route.params.name;
                this.$http.get("http://localhost:8081/user/findUserMo?index=" + index+"&uname="+uname, {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                    this.tableData=req.data.list;
                })
            }, delUser: function (id) {
                if (confirm("是否删除")) {
                    this.$http.get("http://localhost:8081/user/delUser?id=" + id, {xhrFields: {withCredentials: true}}, {crossDomain: true}).then(req => {
                        if(req.data!=null){
                            alert("删除成功");
                            location.reload();

                        }

                    })
                }
            },findById:function (id) {
                //将id传给修改页面，在修改页面进行显示，然后在修改
                this.$router.push({name: "updateUser", params: {id: id}});

            }
        }
    }
</script>

<style scoped>

</style>