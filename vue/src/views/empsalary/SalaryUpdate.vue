<template>
  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

    <el-form-item label="员工编号">
      <el-input v-model="ruleForm.eid" readOnly></el-input>
    </el-form-item>

    <el-form-item label="姓名" prop="ename">
      <el-input v-model="ruleForm.ename"></el-input>
    </el-form-item>
    <el-form-item label="年份" prop="eyear">
      <el-input v-model="ruleForm.eyear"></el-input>
    </el-form-item>

    <el-form-item label="月份" prop="emonth">
      <el-input v-model="ruleForm.emonth"></el-input>
    </el-form-item>
    <el-form-item label="迟到" prop="elate">
      <el-input v-model="ruleForm.elate"></el-input>
    </el-form-item>
    <el-form-item label="早退" prop="eearly">
      <el-input v-model="ruleForm.eearly"></el-input>
    </el-form-item>
    <el-form-item label="奖金" prop="ebonus">
      <el-input v-model="ruleForm.ebonus"></el-input>
    </el-form-item>
    <el-form-item label="最终工资" prop="efinalysalary">
      <el-input v-model="ruleForm.efinalysalary"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>

  </el-form>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        eid: '',
        ename: '',
        eyear: '',
        emonth: '',
        elate: '',
        eearly: '',
        ebonus:'',
        efinalysalary:''
      },
      rules: {
        ename: [
          { required: true, message: '图书名称不能为空', trigger: 'blur' }
        ],
        emonth:[
          { required: true, message: '作者不能为空', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.put('http://localhost:8181/empsalary/update',this.ruleForm).then(function(resp){
            if(resp.data == 'success'){
              _this.$alert('《'+_this.ruleForm.ename+'》修改成功！', '消息', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/EmpSalary')
                }
              })
            }
          })
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8181/empsalary/findById/'+this.$route.query.id).then(function(resp){
      _this.ruleForm = resp.data
    })
  }
}
</script>