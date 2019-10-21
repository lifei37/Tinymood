<template>
  <div>
      <div class="grid-content bg-purple-dark" style="min-height: 900px;">
        <el-col :xs="18" :sm="18" :md="18" :lg="18" :xl="18">
          <ShowMood :userid="userId"></ShowMood>
        </el-col>
        <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6">
          <div class="grid-content bg-purple-dark" style="font-weight: bolder">你关注人列表</div>
          <ul type="none">
            <li class="box" v-for="(follow, index) in followList" :key="index">
              <div class="avatar2" style="float: left">
                <img :src="follow.user.avatar" alt="" style="width: 100%;height: 100% ;">
              </div>
              <div style="padding-top: 20px; text-align: left; margin-left: 80px">
                {{follow.user.nickName}}
              </div>
            </li>
          </ul>
        </el-col>
      </div>
  </div>
</template>

<script>
  import api from "../../store/api";
  import Navigation from "./Navigation";
  import ShowMood from "./ShowMood";
    export default {
        name: 'Follow',
        components:{
            ShowMood,
            Navigation
        },
        data () {
            return {
              userId: sessionStorage.getItem("userId"),
                followList: [],
            }
        },
        created() {
            this.getFollowList();
        },
        methods:{
            getFollowList(){
                let userId = sessionStorage.getItem("userId");
                this.$http.get(api.getfollowlist, {"params":{"userId":userId}}).then(resp=>{
                    console.log(resp)
                    if (resp.body.status == 200) {
                        for (let i of resp.body.obj) {
                            i.user.avatar = api.ip + '/' + i.user.avatar
                            console.log(i.user.avatar)
                        }
                        this.followList = resp.body.obj;
                    }
                })
            }
        }

    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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
