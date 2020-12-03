<template>
  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

    <el-form-item label="员工姓名" prop="ename">
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
    <el-form-item label="奖金" prop="ebonus">
      <el-input v-model="ruleForm.ebonus"></el-input>
    </el-form-item>
    <el-form-item label="最终工资" prop="efinalysalary">
      <el-input v-model="ruleForm.efinalysalary"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>

  </el-form>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        ename: '',
        eyear:'',
        emonth:'',
        elate:'',
        eearly:'',
        ebonus:'',
        efinalysalary:''
      },
      rules: {
        ename: [
          { required: true, message: '姓名不能为空', trigger: 'blur' }
        ]

      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8181/empsalary/save',this.ruleForm).then(function(resp){
            if(resp.data == 'success'){
              _this.$alert(_this.ruleForm.ename+'添加成功！', '消息', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/CheckSalary')
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
  }
}
</script>

