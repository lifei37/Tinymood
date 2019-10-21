<template>
    <el-container>
      <el-aside width="200px">
        <el-row class="tac">
        <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24" style="margin-top: 50px">
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @select="handleOpen"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
            <el-menu-item index="1">
              <i class="el-icon-menu"></i>
              <span slot="title">修改头像</span>
            </el-menu-item>
            <el-menu-item index="2">
              <i class="el-icon-document"></i>
              <span slot="title">修改个人信息</span>
            </el-menu-item>
            <el-menu-item index="3">
              <i class="el-icon-setting"></i>
              <span slot="title">修改密码</span>
            </el-menu-item>
        </el-menu>
          </el-col>
          </el-row>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
</template>

<script>
    export default {
        name: 'UpdateInfo',
        data() {
            return {


            }
        },

        methods: {
            //zuoce caidan
            handleOpen(key, keyPath) {
                console.log(key)
                if(key==1){
                    this.$router.push('avatar')
                }else if(key==2){
                    this.$router.push('info')
                }else{
                    this.$router.push('password')
                }
            },
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }

</style>
