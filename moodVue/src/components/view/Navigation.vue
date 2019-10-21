<template>
  <el-container>
    <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4">
      <div style="height: 150px;width: 150px">
        <img style="width: 100%; height: 100%;overflow: auto" src="@/assets/hom.jpg" alt=""></img>
      </div>
    </el-col>
    <el-col :xs="20" :sm="20" :md="20" :lg="20" :xl="20">
      <el-col :xs="18" :sm="18" :md="18" :lg="18" :xl="18">
        <div style="margin-top: 50px;margin-right: 30px;color:honeydew">总有很多事情是不期而遇，比如你。。。。。</div>
      <div class="grid-content bg-purple-dark" style="margin-top: 50px; padding-left: 20px">
        <el-tabs v-model="selectName" @tab-click="handleClick">
          <el-tab-pane label="花花世界" name="first"></el-tab-pane>
          <el-tab-pane label="你的关注" name="second"></el-tab-pane>
          <el-tab-pane label="你的消息" name="third"></el-tab-pane>
          <el-tab-pane label="个人主页" name="fourth"></el-tab-pane>
        </el-tabs>
      </div>
      </el-col>
      <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6">
        <div v-show="userName" style="margin-top: 10px;background-color: #eaeaea">
          <el-link type="primary" @click="openVerifyContent"><img src="@/assets/notice.svg" alt="" style="height: 25px;width: 25px"></el-link>
          <el-link type="primary" @click="updateInfo" style="margin-left: 5px;margin-right: 5px">{{nickName}}你好啊</el-link>
          <el-link type="primary" @click="logout">登出</el-link>
        </div>
        <div v-show="!userName">
          <el-link type="primary" @click="login">登录</el-link>
        </div>
        <VerifyContent ref="verify"></VerifyContent>
      </el-col>
    </el-col>
    </el-container>
</template>

<script>
  import api from "../../store/api";
  import VerifyContent from "./message/VerifyContent";
    export default {
        name: 'Navigation',
        data () {
            return {
                selectName:sessionStorage.getItem("selectName"),
                // fits: ['cover'],
                // url: '../../assets/hom.jpg',
                userName: sessionStorage.getItem("userName"),
                nickName: sessionStorage.getItem("nickName")
            }
        },
        components:{
            VerifyContent
        },
        methods: {
            handleClick(tab, event) {
                if(tab.name =='fourth'){
                    this.$router.push({name:'person'});
                    sessionStorage.setItem("selectName",tab.name)
                }else if(tab.name =='first'){
                    this.$router.push({name:'home'});
                    sessionStorage.setItem("selectName",tab.name)
                }else if(tab.name =='second'){
                    this.$router.push({name:'follow'});
                    sessionStorage.setItem("selectName",tab.name)
                } else if(tab.name =='third'){
                    this.$router.push({name:'message'});
                    sessionStorage.setItem("selectName",tab.name)
                }
            },
            logout(){
                sessionStorage.clear();
                this.$router.push('/login');
            },
            login(){
                this.$router.push('/login');
            },
            openVerifyContent(){
                this.$refs.verify.getVerifyContent();
            },
            updateInfo(){
                // let user={
                //     "userName": sessionStorage.getItem("userName"),
                //     "id": sessionStorage.getItem("userId")
                // }
                // this.$store.dispatch('setUser', user);
                // window.open('/update', '_blank');
                window.screenWidth = document.body.clientWidth
                if(window.screenWidth>800){
                    window.open('/update');
                }else {
                    this.$router.push('/update');
                }

            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>


</style>
