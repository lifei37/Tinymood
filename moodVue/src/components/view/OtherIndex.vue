<template>
  <div>
    <el-row>
      <el-col :xs="3" :sm="3" :md="3" :lg="3" :xl="3">
        <div class="grid-content bg-purple-dark">&nbsp</div>
      </el-col>
      <el-col :xs="18" :sm="18" :md="18" :lg="18" :xl="18">
        <div class="grid-content bg-purple-dark" style="min-height: 900px;">

          <el-col :xs="18" :sm="18" :md="18" :lg="18" :xl="18">
            <ShowMood ref="getheessay"></ShowMood>
          </el-col>
          <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6">
            <IndexRight ref="right"></IndexRight>
          </el-col>
        </div>
      </el-col>
      <el-col :xs="3" :sm="3" :md="3" :lg="3" :xl="3">
        <div class="grid-content bg-purple-dark">&nbsp</div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    import ShowMood from "./ShowMood";
    import IndexRight from "./IndexRight";
    export default {
        name: 'OtherIndex',
        data() {
            return {
                userId: '',
            }
        },
        components:{
            ShowMood,
            IndexRight
        },
        mounted() {
            let query = window.location.search;
            this.userId = parseInt(query.slice(4,6));
            this.$refs.getheessay.getPersonEsaay(this.userId);
            this.$refs.right.getHeUserInfo(this.userId);
            console.log(this.userId);
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>


</style>
