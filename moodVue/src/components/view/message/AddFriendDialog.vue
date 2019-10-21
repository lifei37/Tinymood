<template>
  <div>
    <el-dialog
      title="添加好友"
      :visible.sync="dialogVisible"
      width="30%">
      <span>加好友需要发送验证信息，请输入验证信息</span>
      <el-input
        type="textarea"
        :autosize="{ minRows: 2, maxRows: 4}"
        placeholder="请输入验证信息"
        v-model="textarea">
      </el-input>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="sendVerification">发 送</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
  import api from "../../../store/api";
    export default {
        name: 'AddFriendDialog',
        data () {
            return {
                textarea:'',
                dialogVisible: false,
                dId:0
            }
        },
        methods:{
            openDialog(dId){
                this.dialogVisible = true;
                this.dId = dId;
            },
            sendVerification(){
                let userId = sessionStorage.getItem("userId")
                this.$http.post(api.verifycontent,{"userId":userId,"collectUserId":this.dId,"content":this.textarea}).
                then(resp=>{
                    if(resp.body.status==200){
                        this.$message({
                            message: '发送成功',
                            type: 'success'
                        });
                        this.dialogVisible = false;
                    }else {
                        this.$message({
                            message: '发送失败',
                            type: 'error'
                        });
                        this.dialogVisible = false;
                    }
                })
            }
        }

    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>


</style>
