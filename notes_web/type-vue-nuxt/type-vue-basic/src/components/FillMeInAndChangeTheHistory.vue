<template>
  <div>
      <form action="#">
          <input type="text" v-model="abc" />
          {{abc}}
      </form>
  </div>
</template>
<script lang="ts">
import Vue from 'vue'
export default Vue.extend({
    data(){
        return{
            abc: "",
        }
    }
})
</script>