<template>
  <div id="app">

<!--    <Login v-if="loginstate" ></Login>-->

    <el-form v-if="loginstate" style="width: 40%" :model="loginForm" :rules="rules" ref="loginForm" label-width="100px" class="demo-ruleForm,aaa">

      <div class="aaa">    <img class="login-tx"  src="./assets/tx.jpg" alt=""></div>

      <el-form-item label="用户名" prop="name">
        <el-input v-model="loginForm.name"></el-input>
      </el-form-item>

      <el-form-item label="密码" prop="author">
        <el-input type="password"  v-model="loginForm.author"></el-input>
      </el-form-item>

      <el-form-item>

        <el-button type="primary" @click="submitForm('loginForm')">登录</el-button>
        <!--      <el-button type="primary" @click="fun(login)">转页面</el-button>-->
        <el-button @click="resetForm('loginForm')">重置</el-button>
      </el-form-item>

    </el-form>

    <el-container v-else  style="height: 500px; border: 1px solid #eee">

      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">

        <el-menu router :default-openeds="['0', '1','2']">
          <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" v-if="item.show">
            <template slot="title">{{item.name}}</template>
            <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path"
                          :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>
          </el-submenu>
        </el-menu>

      </el-aside>

      <el-main>
        <router-view></router-view>
      </el-main>

    </el-container>

  </div>
</template>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
  .aaa{
    display: flex;
    justify-content: center;
  }
  .login-tx{
    justify-content: center;
    height: 70px;
    width: 70px;
    border-radius: 50px;
    border: 1px solid rgba(110,110,110,.5);
    margin-bottom: 30px;
    margin-top: 30px;

  }
  .el-form{
    align-content: center;
  }
</style>

<script>

  export default {
    components:{

    },
    data() {

      return {
        loginstate:true,
        loginForm: {
          name: '',
          author: ''
        }
      }
    },
    rules: {
      name: [
        { required: true, message: '账号名称不能为空', trigger: 'blur' }
      ],
      author:[
        { required: true, message: '密码不能为空', trigger: 'blur' }
      ]
    },
   created() {
      this.loginstate = this.$store.state.loginstate
   },
    methods: {
      submitForm(formName) {
        console.log(this.$refs[formName]);
        const _this = this
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.get('http://localhost:8181/user/login/'+_this.loginForm.name+'/'+_this.loginForm.author).then(function(resp){
              if(resp.data == 'success'){
                _this.$alert(_this.loginForm.name+'登录成功！', '消息', {
                  confirmButtonText: '确定',
                  callback: action => {
                    // _this.$router.push('/BookManage')
                    _this.$store.commit('pushUsers',_this.loginForm)

                    _this.loginstate = false;
                    _this.$store.commit('changloginstate',_this.loginstate)

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
  };
</script>
