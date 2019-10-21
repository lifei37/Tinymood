<template>
  <div>
      <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4" >
        <div>
          <el-col :xs="10" :sm="10" :md="10" :lg="10" :xl="10" >
            <div class="avatar">
              <img :src="myAvatar" alt=""  style="width: 100%;height: 100%;">
            </div>
          </el-col>
          <el-col :xs="14" :sm="14" :md="14" :lg="14" :xl="14" style="padding-top: 20px;">
            <span style="padding-left: 20px;">
              {{myNickName}}
            </span>
          </el-col>
        </div>
        <div style="clear: both"></div>
        <el-row class="tac">
          <el-col :xs="18" :sm="18" :md="18" :lg="18" :xl="18">
            <el-menu
              default-active="1"
              class="el-menu-vertical-demo"
              @select="handleSelect"
              >
              <el-menu-item index="1">
                <i class="el-icon-menu"></i>
                <span slot="title">世界消息</span>
              </el-menu-item>
              <el-menu-item index="2">
                <i class="el-icon-menu"></i>
                <span slot="title">我的消息</span>
              </el-menu-item>
              <el-menu-item index="3">
                <i class="el-icon-document"></i>
                <span slot="title">好友</span>
              </el-menu-item>
              <el-menu-item index="4">
                <i class="el-icon-setting"></i>
                <span slot="title">群列表</span>
              </el-menu-item>
            </el-menu>
          </el-col>
        </el-row>
      </el-col>

      <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6" v-if="contactOrFriend=='contact'">
        <div style="text-align: left;margin-top: 10px;font-weight: bolder">&nbsp;&nbsp;&nbsp;&nbsp;最近联系人列表：</div>
        <ul type="none">
          <li class="box" v-for="(contact, index) in contacts" :key="index" @click="getYourMsg(contact)">
              <div class="avatar2" style="float: left">
                <img :src="contact.user.avatar" alt="" style="width: 100%;height: 100% ;">
              </div>
              <div style="padding-top: 20px; text-align: left; margin-left: 80px">
                {{contact.user.nickName}}
              </div>
          </li>
        </ul>
      </el-col>
<!--      如果是好友下面这个，如果是联系人上面这个ul-->
      <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6" v-if="contactOrFriend=='friend'">
        <div style="text-align: left;margin-top: 10px;font-weight: bolder">&nbsp;&nbsp;&nbsp;&nbsp;好友列表：</div>
        <ul type="none">
          <li class="box" v-for="(friend, index) in friends" :key="index" @click="getYourMsg(friend)">
            <div class="avatar2" style="float: left">
              <img :src="friend.user.avatar" alt="" style="width: 100%;height: 100% ;">
            </div>
            <div style="padding-top: 20px; text-align: left; margin-left: 80px">
              {{friend.user.nickName}}
            </div>
          </li>
        </ul>
      </el-col>
      <el-col :xs="14" :sm="14" :md="14" :lg="14" :xl="14">
        <div v-if="msgType=='All'" style="font-weight: bolder">世界消息</div>
        <div v-else style="font-weight: bolder">和&nbsp;<{{heUserName}}>&nbsp;的聊天：</div>
        <div id="gundong" style="background-color: white;height:300px; overflow: auto">
          <ul type="none" >
            <li v-for="(data, index) in his_msg_data" :key="index" style="text-align: left">
              <el-row>
                <el-col :xs="3" :sm="3" :md="3" :lg="3" :xl="3">
                  <div class="avatar2">
                    <img :src="data.user.avatar" alt="" style="width: 100%;height: 100% ;">
                  </div>
                </el-col>
                <el-col :xs="21" :sm="21" :md="21" :lg="21" :xl="21">
                  <div>{{data.user.nickName}}</div>
                  <div v-if="msgType==='All'">{{data.wmMessage}}</div>
                  <div v-else>{{data.mMessage}}</div>
                </el-col>
              </el-row>
            </li>
          </ul>
<!--          这里是用作切换页面时保证消息不丢失-->
          <ul type="none" >
            <li v-for="(data, index) in msg_data" :key="index" style="text-align: left">
              <el-row>
              <el-col :xs="3" :sm="3" :md="3" :lg="3" :xl="3">
                <div class="avatar2">
                <img :src="data.avatar" alt="" style="width: 100%;height: 100% ;">
              </div>
              </el-col>
              <el-col :xs="21" :sm="21" :md="21" :lg="21" :xl="21">
                <div>{{data.otherNickName}}</div>
                <div>{{data.textMessage}}</div>
              </el-col>
                </el-row>
            </li>
          </ul>
        </div>
        <div>
          <div>上传图片等按钮</div>
          <div>
            <el-input
              type="textarea"
              :autosize="{ minRows: 2, maxRows: 4}"
              placeholder="请输入内容"
              v-model="textarea">
            </el-input>
            <el-button type="success" @click="send()">发送</el-button>
          </div>
        </div>
      </el-col>
  </div>
</template>

<script>
  import api from "../store/api";
  import Navigation from "./view/Navigation";
  import {bus} from "../main.js";
    export default {
        name: 'YourMessage',
        components:{
            Navigation
        },
        data () {
            return {
                his_msg_data:[],
                msg_data:[],
                textarea:'',
                myNickName: sessionStorage.getItem("nickName"),
                myAvatar: api.ip +"/"+ sessionStorage.getItem('avatar'),
                contacts:[],
                friends:[],
                toUserId:0,
                msgType:'All',   //默认等于全部 All世界消息person好友消息group群消息
                contactOrFriend: "contact",
                heUserName: ""
            }
        },

        created() {
            this.initWebSocket();
            this.getMsgData(this.msgType);
        },
        mounted(){
            this.getContacts();
            bus.$on("getYourMes",(friend)=>{
                this.getYourMsg(friend);
            });
        },
        destroyed: function () {
            this.websocketclose();

        },
        // beforeDestroy(){
        //     bus.$off('getYourMes');
        // },

        updated: function(){
            document.getElementById('gundong').scrollTop = document.getElementById('gundong').scrollHeight;
        },
        methods: {
            initWebSocket: function () {
                let username = sessionStorage.getItem("userName")
                this.websock = new WebSocket("ws://49.234.196.87:8000/websocket/" + username);
                this.websock.onopen = this.websocketonopen;
                this.websock.onerror = this.websocketonerror;
                this.websock.onmessage = this.websocketonmessage;
                this.websock.onclose = this.websocketclose;
            },
            websocketonopen: function () {
                console.log("WebSocket连接成功");
            },
            websocketonerror: function (e) {
                console.log(e)
                console.log("WebSocket连接发生错误");
            },
            websocketonmessage: function (e) {
                let da = JSON.parse(e.data);
                if(da.messageType == 3||da.messageType == 2||da.messageType == 1){
                    // 用户上线下线等信息
                    console.log("后面写")
                }else {
                    if(da.avatar){
                        da.avatar = api.ip+'/' + da.avatar
                    }
                    this.msg_data.push(da);
                }


            },
            websocketclose: function (e) {
                // console.log("connection closed (" + e.code + ")");
                this.websock.close()
            },
            send(){
                let username = sessionStorage.getItem("userName")
                let userId = sessionStorage.getItem("userId")
                let avatar = sessionStorage.getItem("avatar")
                let msg = {"message":this.textarea,"username":username,"to":this.msgType,"nickname":this.myNickName,
                "userid": userId, "avatar":avatar,"touserid":this.toUserId}
                this.websock.send(JSON.stringify(msg))
                this.textarea = '';
            },
            getContacts(){
                this.contactOrFriend="contact"
                let userId = sessionStorage.getItem("userId")
                let that = this;
                this.$http.get(api.getcontacts,{"params":{"id":userId}}).then(resp=>{
                    if(resp.body.status==200){
                        let contacts = resp.body.obj
                        for(let i=0,flag=true;i<contacts.length;flag?i++:i){

                            if (contacts[i].user.userName ==sessionStorage.getItem("userName")){
                                contacts.splice(contacts.indexOf(contacts[i]), 1);
                                flag=false
                            }else {
                                contacts[i].user.avatar = api.ip+"/"+ contacts[i].user.avatar
                                flag=true
                            }
                        }
                        that.contacts = contacts
                    }
                })
            },
            handleSelect(key, keyPath) {
                console.log(key,keyPath);

                if(key == 1){
                    this.msgType = "All";
                    this.getMsgData(this.msgType);
                    this.msg_data = [];
                }else if(key == 2){
                    this.getContacts();
                }else if(key == 3){
                    this.getFriends();
                }

            },
            getMsgData(msgType){
                let userId = sessionStorage.getItem("userId")
                if (msgType=="All"){
                    this.$http.get(api.ip+'/message/'+msgType,{"params":{"id":userId}}).then(resp =>{
                        if(resp.body.status==200){
                            for(let item of resp.body.obj){
                                item.user.avatar = api.ip+"/"+ item.user.avatar
                            }
                            this.his_msg_data = resp.body.obj.reverse();
                        }
                    })
                }else if(msgType.nickName){ //这里是点击联系人获取跟这个联系人的消息
                    this.$http.get(api.ip+'/message/'+msgType,{"params":{"id":userId}}).then(resp =>{
                        // console.log(res)
                    })
                }
            },
            getYourMsg(friend) {
                let flag=false;
                this.contactOrFriend = "contact"
                this.msgType = friend.user.userName;
                this.heUserName = friend.user.nickName;
                let userId = sessionStorage.getItem("userId")
                this.toUserId = friend.user.id;
                console.log(this.msgType);
                this.$http.get(api.ip + '/message/' + "person", {"params": {"mFromUserId": userId,
                    "mToUserId":friend.user.id}}).then(resp => {
                    if (resp.body.status == 200) {
                        console.log(resp,"=====");
                        for (let item of resp.body.obj) {
                            item.user.avatar = api.ip + "/" + item.user.avatar
                        }
                        this.his_msg_data = resp.body.obj.reverse();
                        this.msg_data = [];
                        // 判断新加入的聊天对象在不在已经的消息里面
                        for(let contact of this.contacts){
                            if(contact.user.userName==friend.user.userName){
                                this.contacts.splice(this.contacts.indexOf(contact),1);
                                this.contacts.unshift(contact);
                                flag=true;
                                break;
                            }
                        }
                        if(!flag){
                            this.contacts.unshift(friend);
                            console.log(this.contacts);

                        }
                    }
                })
            },
            getFriends(){
                let userId = sessionStorage.getItem('userId');
                this.$http.get(api.getfriends,{"params":{"userId":userId}}).then(resp=>{
                    this.contactOrFriend = "friend"
                    if(resp.body.status==200){
                        let friends = resp.body.obj
                        for(let friend of friends){
                            friend.user.avatar = api.ip+"/"+ friend.user.avatar

                        }
                        this.friends = friends
                    }
                })
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

  .avatar {
    width: 100px;
    height: 100px;
    border: 3px solid white;
    border-radius: 50%;
    overflow: hidden;

  }
  .li{
    margin-top: 10px;
  }
  .avatar2 {
    width: 50px;
    height: 50px;
    border: 1px solid white;
    overflow: hidden;

  }
  .box:after {
    content: '';
    display: block;
    clear: both;
  }
</style>
