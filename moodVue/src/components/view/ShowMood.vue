<template>
    <div>

      <ul type="none" style="margin:0;padding: 0">
        <li v-for="(mood, i) in moodList" :key="i"
            style="margin:20px 0 10px 0;padding: 0;border: 5px solid rgba(255,255,255,.5);">

          <el-row>
            <el-col :xs="3" :sm="3" :md="3" :lg="3" :xl="3">
              <div class="avatar" @click="clickAvatar(i)">
                <!--                头像-->
                <img :src="mood.user.avatar" alt="好友头像" style="width: 100%;height: 100%">
              </div>
            </el-col>
            <el-col :xs="21" :sm="21" :md="21" :lg="21" :xl="21" >
                <div class="info" style="margin-top: 15px">
                  <!--                昵称-->
                  {{mood.user.nickName}}
                </div>
                <div style="margin-top: 15px">
                  <!--                  日期-->
                  {{mood.publishTime}}
                </div>

            </el-col>
          </el-row>
          <el-row class="content" style="margin-top: 20px">
            <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24" style="text-align: left">
              {{mood.content}}
            </el-col>
          </el-row>
          <el-row style="margin-top: 20px; text-align: right">
            <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24" >
              <span class="agree" style="margin-right: 40px" @click="clickAgree(i)">
<!--                  点赞-->
                <i class="el-icon-thumb" style="font-size: x-large"></i> ({{mood.agreeNums}})
              </span>
                <span style="margin-right: 70px" @click="clickComment(i)">
<!--                评论-->
              <i class="el-icon-chat-line-square" style="font-size: x-large"></i> ({{mood.commentNums}})

            </span>
            </el-col>
          </el-row>

        </li>
        <CommentView ref="comm"></CommentView>
        <Dialog ref="dia"></Dialog>
      </ul>

    </div>
</template>

<script>
    import api from "../../store/api";
    import CommentView from "./CommentView";
    import Dialog from "./message/Dialog";
    export default {
        name: 'ShowMood',
        props: ['parent','personId','userid'],
        data() {
            return {
                moodList: [],
                textarea: '',
            }
        },
        components:{
            CommentView,
            Dialog
        },

        mounted() {
            if(this.parent=="home"){
                this.$http.get(api.showmood).then(resp => {
                    if (resp.body.status == 200) {
                        for (let i of resp.body.obj) {
                            i.user.avatar = api.ip + '/' + i.user.avatar
                        }
                        this.moodList = resp.body.obj;
                    }

                })
            }else if(this.personId){
                this.getPersonEsaay(this.personId);
            }else if(this.userid){
                this.getFollowEssay(this.userid);
            }

        },
        methods:{
            clickAgree(i){
                let userId = sessionStorage.getItem('userId')
                let essayId = this.moodList[i].id
                this.$http.post(api.clickagree, {"userId":userId,"essayId":essayId}).then(resp =>{
                    if (resp.body.status == 200){
                        this.moodList[i].agreeNums += 1
                    }else if(resp.body.status == 300){
                        this.moodList[i].agreeNums -= 1
                    }else {
                        console.log(resp)
                    }
                }).catch(error =>{
                    console.log(error)
                })
            },
            clickComment(i){
                this.$refs.comm.getCommentDetail(this.moodList[i].id);
            },
            getPersonEsaay(personId){
                this.$http.get(api.showmood,{"params":{"id":personId}}).then(resp => {
                    if (resp.body.status == 200) {
                        for (let i of resp.body.obj) {
                            i.user.avatar = api.ip + '/' + i.user.avatar
                        }
                        this.moodList = resp.body.obj;
                    }

                })
            },
            getFollowEssay(userid){
                this.$http.get(api.getfollow,{"params":{"userId": userid}}).then(resp=>{
                    if (resp.body.status == 200) {
                        for(let obj of resp.body.obj){
                            for (let i of obj.essay) {
                                i.user.avatar = api.ip + '/' + i.user.avatar
                            }
                            for(let essay of obj.essay){
                                this.moodList.push(essay);
                            }

                        }
                        this.moodList.sort((a,b)=>{
                            var val1 = new Date(a.publishTime);
                            var val2 = new Date(b.publishTime);
                            return val2 - val1;
                        })
                    }
                })
            },
            clickAvatar(i){
                console.log(this.moodList[i].id,'====',this.moodList[i].user.userName)
                this.$refs.dia.getAvatarDetail(this.moodList[i].user.id,this.moodList[i].user.userName,
                    this.moodList[i].user.avatar,this.moodList[i].user.nickName);
            },

        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .clearfix:after {
    content: ".";
    display: block;
    visibility: hidden;
    height: 0;
    clear: both;
  }
  .avatar {
    width: 100px;
    height: 100px;
    border: 1px solid white;
    border-radius: 50%;
    overflow: hidden;
  }

</style>
