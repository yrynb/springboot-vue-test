<template>
  <div>
    <el-table
        :data="tableData"
        border
        style="width: 90%">
      <el-table-column
          fixed
          prop="eid"
          label="员工编号"
          width="120">
      </el-table-column>
      <el-table-column
          prop="ename"
          label="姓名"
          width="120">
      </el-table-column>
      <el-table-column
          prop="eyear"
          label="年份"
          width="120">
      </el-table-column>

      <el-table-column
          prop="emonth"
          label="月份"
          width="120">
      </el-table-column>

      <el-table-column
          prop="elate"
          label="迟到"
          width="120">
      </el-table-column>

      <el-table-column
          prop="eearly"
          label="早退"
          width="120">
      </el-table-column>

      <el-table-column
          prop="ebonus"
          label="奖金"
          width="120">
      </el-table-column>

      <el-table-column
          prop="efinalysalary"
          label="最终工资"
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
      console.log(row.eid);
      axios.get('http://localhost:8181/empsalary/deleteById/'+row.eid).then(function(resp){

        _this.$alert(row.name+'删除成功！', '消息', {
          confirmButtonText: '确定',
          callback: action => {

            // window.location.reload();

            const  _that = _this;
            axios.get('http://localhost:8181/empsalary/findAll/0/6').then(function(resp){
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
        path: '/SalaryUpdate',
        query:{
          id:row.eid
        }
      })
    },
    page(currentPage){
      const _this = this
      axios.get('http://localhost:8181/empsalary/findAll/'+(currentPage-1)+'/6').then(function(resp){
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
      tableData: [
          {
        eid: 1,
        ename: '袁瑞云',
        eyear: 2020,
        emonth:20,
        elate:20,
        Eearly:20,
        efinalySalary:20,
        ebonus:5000
      }
      ]
    }
  },

  created() {
    const _this = this
    axios.get('http://localhost:8181/empsalary/findAll/0/6').then(function(resp){
      console.log(resp)
      console.log(_this.tableData)

      _this.tableData = resp.data.content;
      console.log(resp.data.content);
      console.log(_this.tableData.log);
      _this.pageSize = resp.data.size;
      _this.total = resp.data.totalElements;
    })
  }
}
</script>