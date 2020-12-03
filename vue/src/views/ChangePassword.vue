<template>
<div>
  <el-form  style="width: 40%" :model="loginForm" :rules="rules" ref="loginForm" label-width="100px" class="demo-ruleForm,aaa">

    <el-form-item label="用户名" prop="name">
      <el-input v-model="loginForm.name" disabled></el-input>
    </el-form-item>

    <el-form-item label="输入新密码" prop="password">
      <el-input type="password"  v-model="loginForm.password"></el-input>
    </el-form-item>

    <el-form-item>

      <el-button type="primary" @click="submitForm('loginForm')">保存</el-button>
      <el-button @click="resetForm('loginForm')">重置</el-button>
    </el-form-item>

  </el-form>
</div>
</template>

<script>
export default {
name: "ChangePassword",
  created() {
  this.loginForm.name = this.$store.state.user.name;
  },
  data() {
    return {
      login:true,
      loginForm: {
        name: '',
        password: ''
      },
      rules: {
        name: [
          { required: true, message: '账号名称不能为空', trigger: 'blur' }
        ],
        author:[
          { required: true, message: '密码不能为空', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    // fun(login){
    // this.login = false;
    // this.$emit('loginstate',this.login)
    // },
    submitForm(formName) {
      console.log(this.$refs[formName]);
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.get('http://localhost:8181/user/changepwd/'+_this.loginForm.name+'/'+_this.loginForm.password).then(function(resp){
            if(resp.data == 'success'){
              _this.$alert(_this.loginForm.name+'修改密码成功！', '消息', {
                confirmButtonText: '确定',
                callback: action => {
                   _this.$router.push('/BookManage');
                  _this.login = false;
                  _this.$emit('loginstate',_this.login);
                  window.location.reload();
                }

              })
            }else{

              _this.$alert('账号或者密码错误,请重新输入', '消息', {
                confirmButtonText: '确定'

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

<style scoped>

</style>