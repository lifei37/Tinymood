<template>
  <div>
      <div>
        <img :src="url" alt="" style="overflow: auto;height: 175px;width: 179px;margin-top: 50px;padding: 0">
      </div>
    <div class="lineleft" style="text-align: left">
        <div>个人简介:</div>
      <div style="margin-top: 10px">
        {{introduction}}
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
                url:'',
                introduction: '',
            }
        },
        methods: {
            getHeUserInfo(hId){
                this.$http.get(api.getuserinfo,{"params":{"userId":hId}}).then(resp=>{
                    console.log(resp.body)
                    this.introduction = resp.body.obj.desc;
                    console.log(resp.body.obj)
                    this.url = api.ip+'/'+resp.body.obj.avatar;
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
