<template>
  <el-form ref="form" :model="form" label-width="80px" class="register-container" >
    <h2>记录心情</h2>
    <el-form-item label="用户名">
      <el-input v-model="form.userName"></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input placeholder="请输入密码" v-model="form.password" show-password></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitClick" >登录</el-button>
      <el-link href="/register" type="primary" style="margin-left: 30px">注册</el-link>
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
                    userName: '',
                    password: ''
                }
            }
        },
        methods: {
            submitClick: function () {
                this.$http.post(api.login,this.form).then((resp)=>{
                    if(resp.body.status==200){
                        this.$store.dispatch('setUser', resp.body.obj)
                        sessionStorage.setItem('userName',resp.body.obj.userName);
                        sessionStorage.setItem('userId',resp.body.obj.id);
                        sessionStorage.setItem('nickName',resp.body.obj.nickName);
                        sessionStorage.setItem('avatar',resp.body.obj.avatar);
                        this.$message({
                            message: '登录成功',
                            type: 'success'
                        })
                        this.$router.push('home');
                        sessionStorage.setItem("selectName","first")
                    }else {
                        this.$message({
                            message: '用户名或密码错误',
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
