<template>
  <div>
    <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
      <div class="grid-content bg-purple-dark" style="min-height: 900px;">
        <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6">
          <IndexLeft></IndexLeft>
        </el-col>
        <el-col :xs="18" :sm="18" :md="18" :lg="18" :xl="18">
          <el-row style="margin-top: 30px;">
            <el-col :xs="20" :sm="20" :md="20" :lg="20" :xl="20">
              <el-input
                type="textarea"
                :autosize="{ minRows: 2, maxRows: 4}"
                placeholder="书写心情"
                v-model="textarea">
              </el-input>
            </el-col>
            <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4" style="margin-top: 10px">
              <el-button type="primary" @click="postEssay()">书写心情</el-button>
            </el-col>
          </el-row>
          <ShowMood :personId="userId" ref="reloads"></ShowMood>
        </el-col>
      </div>
    </el-col>
  </div>
</template>

<script>
    import api from '@/store/api'
    import ShowMood from "./view/ShowMood";
    import Navigation from "./view/Navigation";
    import IndexLeft from "./view/IndexLeft";
    export default {
        name: 'PersonIndex',
        data () {
            return {
                userId:sessionStorage.getItem('userId'),
                textarea:''
            }
        },
        components:{
            ShowMood,
            Navigation,
            IndexLeft
        },
        methods:{
            postEssay(){
                this.$http.post(api.postessay,{"userId":this.userId,"content":this.textarea}).then(resp=>{
                    if(resp.body.status==200){
                        this.$refs.reloads.getPersonEsaay(this.userId);
                        this.textarea='';
                    }
                })
            }
        }

    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
