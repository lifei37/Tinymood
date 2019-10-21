<template>
  <div>
    <el-card shadow="always" class="box">
      <el-row :gutter="20">
        <el-col :xs="24" :sm="24" :md="6" :lg="18" :xl="18">
          <div class="boxbody">
            <el-form :model="myForm" status-icon :rules="rules" ref="myForm" label-width="100px" class="demo-ruleForm">
              <el-form-item label="旧密码" prop="oldPass" required>
                <el-input type="password" v-model="myForm.oldPass" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="新密码" prop="pass" required>
                <el-input type="password" v-model="myForm.pass" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="checkPass" required>
                <el-input type="password" v-model="myForm.checkPass" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="submitForm('myForm')">提交</el-button>
                <el-button @click="resetForm('myForm')">重置</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
  import api from "../../../store/api";
    export default {
        name: 'UpdatePassword',
        data () {
            var validateOldPass = (rule, value, callback) => {
                if (value === ''){
                    callback(new Error('请输入旧密码'));
                } else {
                    this.checkOldPwd(value);
                }
                setTimeout(() => {
                    if (!this.flag) {
                        callback(new Error('请输入正确的密码'));
                    } else {
                        callback();
                    }
                }, 1000);
            };
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入新密码'));
                } else {
                    if (this.myForm.checkPass !== '') {
                        this.$refs.myForm.validateField('checkPass');
                    }
                    callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.myForm.pass) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                flag: false,
                myForm: {
                    oldPass: '',
                    pass: '',
                    checkPass: ''
                },
                rules: {
                    oldPass: [
                        { validator: validateOldPass, trigger: 'blur' }
                    ],
                    pass: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    checkPass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ],
                }
            };
        },
        methods: {
            // check old password
            checkOldPwd(value){

                let params = {
                    'userName': sessionStorage.getItem("userName"),
                    'password': value
                }
                this.$http.post(api.checkpwd,params).then((resp)=>{
                    let status = resp.body.status;
                    if(status == 200){
                        this.flag = true;
                    } else {
                        this.flag = false;
                    }
                })
            },
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let params = {
                            'password': this.myForm.pass,
                            'userName': sessionStorage.getItem("userName"),
                        }
                        this.$http.put(api.checkpwd, params).then((resp)=>{
                            if(resp.body.status == 200){
                                this.$alert('修改成功，请重新登录', '提示', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        sessionStorage.clear();
                                        this.$router.push('/login');
                                    }
                                });
                            } else {
                                this.$message({
                                    type: 'error',
                                    message: '修改失败!'
                                });
                                this.resetForm('myForm');
                            }

                        }, (err)=>{
                            this.$message({
                                type: 'error',
                                message: '出现未知错误!'
                            });
                        })
                    } else {
                        // console.log('error submit!!');
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.box{
  width: 600px;
  height: 300px;
}

</style>
