<template>
  <div>
    <el-card class="box-card">
    <el-form>
    <el-form-item label="上传头像">
      <el-upload
        class="avatar-uploader"
        action="/dev/avatar"
        :show-file-list="false"
        :on-success="handleAvatarSuccess"
        :before-upload="beforeAvatarUpload">
        <img v-if="imageUrl" :src="imageUrl" class="avatar">
        <div v-else style="margin-top: 200px;margin-right: 50px">
          <i class="el-icon-plus avatar-uploader-icon"></i>
        </div>
        <span style="color: red">图片格式为jpg/png，图片大小不大于2M</span>

      </el-upload>
    </el-form-item>
    </el-form>
      </el-card>
  </div>
</template>

<script>
    export default {
        name: 'UpAvatar',
        data () {
            return {
                imageUrl: '',
            }
        },
        methods:{
            // 头像部分方法
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {

                const isJPG = file.type === 'image/jpeg';
                const isPNG = file.type === 'image/png';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG && !isPNG) {
                    this.$message.error('上传头像图片只能是 JPG/PNG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
            },
        }

    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .box-card {
    width: 500px;
    height: 500px;
  }
  .avatar{
    width: 100%;
    height: 100%;
    overflow: auto;
  }

</style>
