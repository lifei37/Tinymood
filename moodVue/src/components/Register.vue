<template>
    <el-form ref="form" :model="form" label-width="80px" class="register-container">
      <h2>记录心情</h2>
      <el-form-item label="用户名">
        <el-input v-model="form.userName"></el-input>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="form.nickName"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input placeholder="请输入密码" v-model="form.password" show-password></el-input>
      </el-form-item>
      <el-form-item label="确认密码">
        <el-input placeholder="请输入密码" v-model="form.re_password" show-password></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">注册</el-button>
        <el-link href="/login" type="primary" style="margin-left: 30px">已有账号，去登录</el-link>
      </el-form-item>
    </el-form>
</template>

<script>
    import api from '@/store/api'
export default {
  name: 'Register',
  data () {
    return {
        form: {
            userName: "",
            password: "",
            nickName:"",
            re_password: "",
        },


    }
  },
    methods: {
        onSubmit() {
            this.$http.post(api.register,this.form).then((resp)=>{
                console.log(resp.body.status)
                if(resp.body.status==200){
                    this.$message({
                        message: '注册成功',
                        type: 'success'
                    })
                    this.$router.push('login')
                }else {
                    this.$message({
                        message: resp.body.msg,
                        type: 'error'
                    })
                }
            }).catch(error =>{
                console.log(error)
            });
        }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .register-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 100px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
</style>
