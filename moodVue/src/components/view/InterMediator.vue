<template>
  <div>
      <Dialog @message="GoMessage"></Dialog>
      <YourMessage ref="mes"></YourMessage>
  </div>
</template>

<script>
  import Dialog from "./message/Dialog";
  import YourMessage from "../YourMessage";
    export default {
        name: 'InterMediator',
        data () {
            return {

            }
        },
        components:{
            Dialog,
            YourMessage
        },
        methods:{
            GoMessage(user){
                console.log(user,'++++');
                this.$refs.mes.getYopurMsg(user);
            }
        }

    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>


</style>
