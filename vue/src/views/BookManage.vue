<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 80%">
            <el-table-column
                    fixed
                    prop="id"
                    label="员工编号"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="姓名"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="sex"
                    label="性别"
                    width="120">
            </el-table-column>

          <el-table-column
              prop="age"
              label="年龄"
              width="120">
          </el-table-column>

          <el-table-column
              prop="basesalary"
              label="基本工资"
              width="120">
          </el-table-column>

          <el-table-column
              prop="dept"
              label="部门"
              width="120">
          </el-table-column>

          <el-table-column
              prop="address"
              label="籍贯"
              width="120">
          </el-table-column>

            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {

            deleteBook(row){

                const _this = this;
                axios.delete('http://localhost:8181/book/deleteById/'+row.id).then(function(resp){

                    _this.$alert(row.name+'删除成功！', '消息', {
                        confirmButtonText: '确定',
                        callback: action => {

                            // window.location.reload();

                          const  _that = _this;
                          axios.get('http://localhost:8181/book/findAll/0/6').then(function(resp){
                            console.log(resp)
                            _this.tableData = resp.data.content
                            _this.pageSize = resp.data.size
                            _this.total = resp.data.totalElements
                          })

                        }
                    })
                })
            },
            edit(row) {
                this.$router.push({
                    path: '/update',
                    query:{
                        id:row.id
                    }
                })
            },
            page(currentPage){
                const _this = this
                axios.get('http://localhost:8181/book/findAll/'+(currentPage-1)+'/6').then(function(resp){
                    console.log(resp)
                    _this.tableData = resp.data.content
                    _this.pageSize = resp.data.size
                    _this.total = resp.data.totalElements
                })
            }
        },

        data() {
            return {
                loginstate:false,
                pageSize:'1',
                total:'11',
                tableData: [{
                    id: 1,
                    name: '袁瑞云',
                    sex: '男',
                  age:20,
                  basesalary:5000,
                  dept:'人事',
                  address:'南京'

                }, {
                    id: 2,
                    name: 'tzy',
                    sex: '女',
                  age:20,
                  basesalary:5000,
                  dept:'人事',
                  address:'南京'

                }, {
                    id: 3,
                    name: 'yry',
                    sex: '男',
                  age:20,
                  basesalary:5000,
                  dept:'人事',
                  address:'南京'


                }]
            }
        },

        created() {
            const _this = this
            axios.get('http://localhost:8181/book/findAll/0/6').then(function(resp){
                console.log(resp)
                _this.tableData = resp.data.content
                _this.pageSize = resp.data.size
                _this.total = resp.data.totalElements
            })
        }
    }
</script>