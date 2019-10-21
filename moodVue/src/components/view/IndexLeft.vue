<template>
  <div>
      <div class="lineleft">
        <el-col :xs="10" :sm="10" :md="10" :lg="10" :xl="10" style="text-align: center ">
              心情:
        </el-col>
        <el-col :xs="14" :sm="14" :md="14" :lg="14" :xl="14" style="text-align: left; ">
              {{essayCount}}
        </el-col>
      </div>
    <div class="lineleft" style="text-align: left">
        <div>个人简介:</div>
      <div style="margin-top: 10px">
        {{introduction}}
      </div>
    </div>
    <div class="lineleft">
        <div>访客:</div>
      <div>

      </div>
    </div>
  </div>
</template>

<script>
  import api from "../../store/api";
    export default {
        name: 'IndexLeft',
        data () {
            return {
                essayCount:0,
                introduction: '',
            }
        },
        mounted() {
          this.getEssaycount();
          this.getUserInfo();
        },
        methods: {
            getEssaycount(){
                this.$http.post(api.getessaycount, {"userId":sessionStorage.getItem("userId")}).then(resp=>{
                    console.log(resp.body,'====')
                    this.essayCount = resp.body.obj;
                })
            },
            getUserInfo(){
                this.$http.get(api.getuserinfo,{"params":{"userId":sessionStorage.getItem("userId")}}).then(resp=>{
                    console.log(resp.body)
                    this.introduction = resp.body.obj.desc
                })
            }
        }

    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.lineleft{
  min-height: 100px;
  margin-top: 15px;
  border: solid 1px;
}

</style>
