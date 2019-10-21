<template>
  <el-container>
      <el-dialog
        title="评论"
        :visible.sync="dialogVisible"
        width="40%"
        :close-on-click-modal="false"
        >
        <ul type="none" style="margin:0;padding: 0;height: 400px; overflow: auto">
          <li v-for="(comment, i) in commentList" :key="i"
              style="margin:5px 0 0 0;padding: 0;border: 20px solid rgba(255,255,255,.5);">
            <el-row>
              <el-col :xs="2" :sm="2" :md="2" :lg="2" :xl="2">
                <div class="avatar">
                  <!--                头像-->
                  <img :src="comment.user.avatar" alt="好友头像" style="width: 100%;height: 100%">
                </div>
              </el-col>
              <el-col :xs="20" :sm="20" :md="20" :lg="20" :xl="20" style="text-align: left; padding-left: 20px">
                <div class="info" style="margin-top: 15px">
                  <!--                昵称-->
                  {{comment.user.nickName}}
                </div>
                <div style="margin-top: 15px">
                  <!--                  日期-->
                  {{comment.addTime}}
                </div>
              </el-col>
            </el-row>
            <el-row class="content" style="margin-top: 20px">
              <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24" style="text-align: left">
                {{comment.comment}}
              </el-col>
            </el-row>
          </li>
        </ul>
        <el-row>
          <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
            <div>
                <el-row style="margin-top: 30px;">
                  <el-col :xs="20" :sm="20" :md="20" :lg="20" :xl="20">
                    <el-input
                      type="textarea"
                      :autosize="{ minRows: 2, maxRows: 4}"
                      placeholder="发表评论"
                      v-model="textarea">
                    </el-input>
                    </el-col>
                    <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4" style="margin-top: 10px">
                      <el-button type="primary" @click="postComment()">提交评论</el-button>
                    </el-col>
                </el-row>
            </div>
          </el-col>
        </el-row>
      </el-dialog>
  </el-container>
</template>

<script>
  import api from "../../store/api";
    export default {
        name: 'CommentView',
        data () {
            return {
                dialogVisible: false,
                commentList: [],
                textarea: "",
                essayId: 0
            }
        },
        methods:{

            getCommentDetail(eid){
                this.essayId = eid
                this.dialogVisible = true;
                this.$http.get(api.comment,{"params":{"essayId":eid}}).then((resp)=>{
                    console.log(resp)
                    if (resp.body.status == 200) {
                        for (let i of resp.body.obj) {
                            i.user.avatar = api.ip + '/' + i.user.avatar
                            console.log(i.user.avatar)
                        }
                        this.commentList = resp.body.obj;
                    }
                }).catch((err)=>{});
            },
            postComment(){
                let userId = sessionStorage.getItem('userId')
                let essayId = this.essayId
                this.$http.post(api.postcomment,{"userId":userId,"essayId":essayId,"comment":this.textarea}).then(resp =>{
                    if (resp.body.status == 200){
                        this.getCommentDetail(essayId);
                        this.textarea = ''
                    }
                    console.log("报错了")
                }).catch((err)=>{});
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

</style>
