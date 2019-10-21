<template>
  <div>
    <el-backtop :bottom="100">
      <div
        style="{
        height: 100%;
        width: 100%;
        background-color: #f2f5f6;
        box-shadow: 0 0 6px rgba(0,0,0, .12);
        text-align: center;
        line-height: 40px;
        color: #1989fa;
      }"
      >
        UP
      </div>
    </el-backtop>
    <el-row>

      <el-col :xs="3" :sm="3" :md="3" :lg="3" :xl="3"><div class="grid-content bg-purple-dark">&nbsp</div></el-col>
      <el-col :xs="18" :sm="18" :md="18" :lg="18" :xl="18">
        <Navigation ref="Navigation" />
        <router-view></router-view>
      </el-col>
      <el-col :xs="3" :sm="3" :md="3" :lg="3" :xl="3"><div class="grid-content bg-purple-dark">&nbsp</div></el-col>

    </el-row>
  </div>
</template>

<script>
  import Navigation from "./view/Navigation";
    export default {
        name: 'Index',
        data () {
            return {

            }
        },
        components:{
            Navigation
        }

    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>


</style>
