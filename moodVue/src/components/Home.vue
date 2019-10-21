<template>
    <div class="grid-content bg-purple-dark" style="min-height: 900px;">
      <el-col :xs="18" :sm="18" :md="18" :lg="18" :xl="18">
        <ShowMood :parent="names"></ShowMood>
      </el-col>
      <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6">
        <div class="grid-content bg-purple-dark" style="font-weight: bolder;margin-bottom: 20px">心情热度排行榜</div>
        <ul type="none">
          <li v-for="(mood, index) in topMoodList" :key="index">
            <div style="text-align: left;margin-bottom: 5px">
              <span style="font-weight: bolder">{{index+1}}、</span>
              <span>{{mood.content.substr(0,30)}}</span>
            </div>
          </li>
        </ul>
      </el-col>
    </div>
</template>

<script>
    import api from '@/store/api'
    import Navigation from "./view/Navigation";
    import ShowMood from "./view/ShowMood";
    export default {
        name: 'Home',
        components:{
            Navigation,
            ShowMood
        },
        data () {
            return {
                names:"home",
                topMoodList: [],
            }
        },
        methods: {
            getHeatTop10(){
                this.$http.get(api.getheat10).then(resp=>{
                    console.log(resp)
                    this.topMoodList = resp.body.obj;
                })
            }
            },
        created() {
            this.getHeatTop10();

        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
