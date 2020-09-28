<template>
  <div class="press-me">
      <h2>{{countData}}</h2>
      <button type="button" v-on:click="onPressHandler">PressMe</button>
      <h2>{{initCount}}</h2>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  name: 'HelloWorld',
  props: {
    initCount: Number,
  },

  data(){
      return {
          countData: this.initCount || 0,
      }
  },
  methods:{
      onPressHandler: function(){
          this.countData++;
        //! this.count++; // read-only
      }
  },
})
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
