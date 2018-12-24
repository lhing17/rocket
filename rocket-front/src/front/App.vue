<template>
  <div id="app">
    <img src="./assets/logo.png">
    <h1>{{ message }}</h1>
    <rocket-select></rocket-select>
    <el-button type="success">成功按钮</el-button>
    <el-button type="warning">警告按钮</el-button>
    <el-button type="danger">警告按钮</el-button>
    <el-button type="info">警告按钮</el-button>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      message: 'This is my first VUE project'
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
