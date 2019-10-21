<template>
  <div>
      <el-dialog
        title="好友请求"
        :visible.sync="dialogVisible"
        width="40%"
        :close-on-click-modal="false"
        >
        <ul type="none" style="margin:0;padding: 0;height: 500px; overflow: auto">
          <li v-for="(content, i) in verifyContentList" :key="i"
              style="margin:5px 0 0 0;padding: 0;border: 20px solid rgba(255,255,255,.5);">
            <el-row>
              <el-col :xs="18" :sm="18" :md="18" :lg="18" :xl="18" style="text-align: left">
                  <span >
                    <img :src="content.user.avatar" alt="" style="width: 50px;height: 50px;">
                  </span>
                  <span style="margin-bottom: 20px">{{content.user.nickName}}</span>
              </el-col>
              <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6">
                <span @click="agreeFriend(i)"><img src="@/assets/yes.svg" alt="" style="width: 30px;height: 30px"></span>
                <span @click="notAgreeFriend"><img src="@/assets/no.svg" alt="" style="width: 30px;height: 30px"></span>
              </el-col>
            </el-row>
            <div style="text-align: left; margin-top: 5px;border: 1px solid black;min-height: 50px">
              验证信息：{{content.vSendContent}}</div>
          </li>
        </ul>
      </el-dialog>
  </div>
</template>

<script>
  import api from "../../../store/api";
    export default {
        name: 'VerifyContent',
        data () {
            return {
                dialogVisible: false,
                verifyContentList: []
            }
        },
        methods:{
            getVerifyContent(){
                this.dialogVisible = true;
                let userId = sessionStorage.getItem("userId")
                this.$http.get(api.getverifycontent,{"params":{"userId":userId}}).then(resp=>{
                    if(resp.body.status==200){
                        console.log(resp)
                        for(let content of resp.body.obj){
                            content.user.avatar = api.ip + '/' + content.user.avatar
                        }
                        this.verifyContentList = resp.body.obj;
                    }
                })
            },
            agreeFriend(i){
                let friendId = this.verifyContentList[i].vUserId;
                let friendNickName = this.verifyContentList[i].user.nickName;
                let userId = sessionStorage.getItem("userId");
                let nickName = sessionStorage.getItem('nickName');
                console.log(nickName,friendNickName);
                this.$http.post(api.addfriend,{"friendId":friendId,"userId":userId,"friendNickName":friendNickName,
                "nickName":nickName}).then(resp=>{
                    if(resp.body.status==200){
                        this.$message({
                            message: '添加好友成功',
                            type: 'success'
                        });
                        this.dialogVisible = false;
                    }else {
                        this.$message({
                            message: '添加好友失败',
                            type: 'error'
                        });
                        this.dialogVisible = false;
                    }
                })
            },
            notAgreeFriend(){

            }

        }

    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .avatar {
    width: 70px;
    height: 70px;
    border: 3px solid white;
    border-radius: 50%;
    overflow: hidden;
  }
  .avatar2 {
    width: 30px;
    height: 30px;
    border: 3px solid white;
    border-radius: 50%;
    overflow: hidden;
  }

</style>
