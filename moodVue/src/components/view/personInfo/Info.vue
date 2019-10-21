<template>
  <div>
    <el-card class="box-card">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

      <el-form-item label="昵称" prop="nickname">
        <el-input v-model="ruleForm.nickname"></el-input>
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-radio v-model="gender" label="1">男</el-radio>
        <el-radio v-model="gender" label="2">女</el-radio>
      </el-form-item>
      <el-form-item label="生日" required>
        <el-col :xs="11" :sm="11" :md="11" :lg="11" :xl="11">
          <el-form-item prop="date1">
            <el-date-picker
              v-model="ruleForm.date1"
              type="date"
              placeholder="选择日期">
            </el-date-picker>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="简介" prop="desc">
        <el-input
          type="textarea"
          :autosize="{ minRows: 2, maxRows: 4}"
          placeholder="请输入内容"
          v-model="ruleForm.desc">
        </el-input>
      </el-form-item>
      <el-form-item label="电话" prop="phone">
        <el-input v-model="ruleForm.phone"></el-input>
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input v-model="ruleForm.address"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即修改</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
      </el-card>
  </div>
</template>

<script>
  import api from "../../../store/api";
    export default {
        name: 'Info',
        data () {
            return {
                gender: '1',
                ruleForm: {
                    nickname: '',
                    date1: '',
                    desc: '',
                    phone: 0,
                    address: ''
                },
                rules: {
                    nickname: [
                        {required: true, message: '不能输入为空', trigger: 'change'}
                    ],
                    date1: [
                        {type: 'date', required: true, message: '请选择日期', trigger: 'change'}
                    ],
                    desc: [
                        {required: false, message: '不能输入为空', trigger: 'change'}
                    ],
                    phone: [
                        {required: false, message: '不能为空，并且要为数字', trigger: 'change'}
                    ],
                    address: [
                        {required: false, message: '请填写活动形式', trigger: 'change'}
                    ]
                },
            }
        },
        mounted(){
            console.log(sessionStorage.getItem("userName"));
            this.getInfo();
        },
        methods:{
            submitForm(formName) {
                let that = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.updateInfo(that);
                        alert('提交成功');
                    } else {
                        console.log('提交失败');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            getInfo(){
                this.$http.get(api.getuser).then(resp=>{
                    if(resp.body.status==200){
                        this.ruleForm.nickname=resp.body.obj.nickName;
                        if(resp.body.obj.birthday){
                            this.ruleForm.date1=resp.body.obj.birthday;
                        }
                        this.ruleForm.desc = resp.body.obj.desc;
                        this.ruleForm.phone=resp.body.obj.phone;
                        this.ruleForm.address = resp.body.obj.address;
                        if(resp.body.obj.sex=="1"){
                            this.gender="1";
                        }
                        else {
                            this.gender="2";
                        }
                    }
                })
            },
            updateInfo(that){
                let form = {
                    "nickname":this.ruleForm.nickname,
                    "gender": this.gender,
                    "phone": this.ruleForm.phone,
                    "address": this.ruleForm.address,
                    "date1": this.ruleForm.date1,
                    "desc": this.ruleForm.desc
                };
                this.$http.put(api.getuser,form).then(resp=>{
                    console.log(resp)
                })
            }
        }

    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .box-card {
    width: 800px;
    height: 500px;
  }

</style>
