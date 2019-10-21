<template>
  <div>
    <el-dialog
      title="选你喜欢"
      :visible.sync="dialogVisible"
      width="30%">
      <div style="margin-bottom: 30px"><el-link @click="toIndex" type="primary" >去它主页</el-link></div>
      <div style="margin-bottom: 30px"><el-link @click="followHe" type="primary" >关注它</el-link></div>
      <div style="margin-bottom: 30px"><el-link @click="addFriend" type="primary" >加它好友</el-link></div>
      <div style="margin-bottom: 30px"><el-link @click="sendMessage" type="primary" >发消息</el-link></div>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
  </span>
    </el-dialog>
    <AddFriendDialog ref="addfriend"></AddFriendDialog>
  </div>
</template>

<script>
  import api from "../../../store/api";
  import AddFriendDialog from "./AddFriendDialog";
  import {bus} from "../../../main.js"
    export default {
        name: 'Dailog',
        data () {
            return {
                dialogVisible: false,
                dId: 0,
                heUserName:"",
                heAvatar:"",
                heNickName:"",
                form:{
                    "user":{
                        "userName": "",
                        "id": 0,
                        "avatar":"",
                        "nickName":""
                    }
                }
            }
        },
        components:{
            AddFriendDialog
        },
        methods:{
            getAvatarDetail(uid,userName,avatar,nickName){
              this.dId = uid;
              this.heUserName = userName;
              this.heAvatar = avatar;
              this.heNickName = nickName;
              this.dialogVisible = true;
            },
            toIndex(){
                window.screenWidth = document.body.clientWidth
                if(window.screenWidth>800){
                    this.$store.dispatch('setHeUser', this.dId);
                    let routeData = this.$router.resolve({path: '/otherIndex', query: {id: this.dId}});
                    window.open(routeData.href, '_blank');
                    this.dialogVisible = false;
                }else {
                    this.$router.push({path: '/otherIndex', query: {id: this.dId}});
                }
            },
            followHe(){
                let userId = sessionStorage.getItem('userId')
                console.log(this.dId)
                this.$http.post(api.addfollow,{"userId":userId,"followUserId":this.dId}).then(resp=>{
                    console.log(resp)
                    if(resp.body.status==200){
                        this.$message({
                            message: '关注成功',
                            type: 'success'
                        });
                        this.dialogVisible = false;
                    }else {
                        this.$message({
                            message: '关注失败',
                            type: 'error'
                        });
                        this.dialogVisible = false;
                    }
                })
            },
            addFriend(){
                let userId = sessionStorage.getItem("userId");
                if(this.dId!=userId){
                    this.dialogVisible = false;
                    this.$refs.addfriend.openDialog(this.dId);
                }else {
                    this.$message({
                        message: '不能添加自己为好友',
                        type: 'error'
                    })
                }

            },
            sendMessage(){
                this.dialogVisible = false;
                this.$router.push("message");
                this.form.user.userName = this.heUserName;
                this.form.user.id = this.dId;
                this.form.user.nickName = this.heNickName;
                this.form.user.avatar = this.heAvatar;
                // this.$set(this.form.user,userName,this.heUserName);
                // this.$set(this.form.user,id ,this.dId);
                // this.$set(this.form.user,nickName,this.heNickName);
                // this.$set(this.form.user,avatar,this.heAvatar);
                bus.$emit("getYourMes",this.form);

            }
        }

    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>


</style>
