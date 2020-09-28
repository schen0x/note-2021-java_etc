<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>
    <PressMe :initCount=2 />
    <FillMeIn />
    <fill-me-in></fill-me-in> 
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import HelloWorld from '@/components/HelloWorld.vue' // @ is an alias to /src
import PressMe from '@/components/PressMe.vue' // @ is an alias to /src
import FillMeIn from '@/components/FillMeInAndChangeTheHistory.vue' // @ is an alias to /src

export default Vue.extend({
  name: 'Home',
  components: {
    HelloWorld,
    PressMe,
    FillMeIn,
  }
})
</script>
