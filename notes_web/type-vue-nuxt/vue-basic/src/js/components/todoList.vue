<template>
  <div id="app">
    <div v-bind:id="'list-' + id">abc</div>
    {{ message }}
  </div>
</template>

<script>
var app = new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue!'
  },
})
</script>