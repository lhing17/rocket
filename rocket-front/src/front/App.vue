<template>
  <div id="app">
    <router-view name="blank"></router-view>
    <router-view v-if="isRouterAlive"></router-view>
  </div>
</template>

<script>
  export default {
    name: 'app',
    data() {
      return {
        isRouterAlive: true
      }
    },
    methods: {
      reload() {
        this.isRouterAlive = false;
        this.$nextTick(() => (this.isRouterAlive = true))
      }
    }
  }
</script>

<style lang="less">
  #app {
    background-color: #222d32;
  }

</style>
