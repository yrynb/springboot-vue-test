<template>
    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

        <el-form-item label="员工姓名" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>

        <el-form-item label="性别" prop="sex">
            <el-input v-model="ruleForm.sex"></el-input>
        </el-form-item>

      <el-form-item label="年龄" prop="age">
        <el-input v-model="ruleForm.age"></el-input>
      </el-form-item>

      <el-form-item label="基本工资" prop="basesalary">
        <el-input v-model="ruleForm.basesalary"></el-input>
      </el-form-item>
      <el-form-item label="部门" prop="dept">
        <el-input v-model="ruleForm.dept"></el-input>
      </el-form-item>

      <el-form-item label="地址" prop="address">
        <el-input v-model="ruleForm.address"></el-input>
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
                    name: '',
                    sex:'',
                  age:'',
                  basesalary:'',
                  dept:'',
                  address:'',
                },
                rules: {
                    name: [
                        { required: true, message: '姓名不能为空', trigger: 'blur' }
                    ],
                    sex:[
                        { required: true, message: '性别不能为空', trigger: 'blur' }
                    ],
                  age:[
                    { required: true, message: '年龄不能为空', trigger: 'blur' }
                  ],
                  basesalary:[
                    { required: true, message: '基本工资不能为空', trigger: 'blur' }
                  ],
                  dept:[
                    { required: true, message: '部门信息不能为空', trigger: 'blur' }
                  ],
                  address:[
                    { required: true, message: '地址不能为空', trigger: 'blur' }
                  ],
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post('http://localhost:8181/book/save',this.ruleForm).then(function(resp){
                            if(resp.data == 'success'){
                                _this.$alert('《'+_this.ruleForm.name+'》添加成功！', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/BookManage')
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

