<!--编辑页面的表单项-->
<template>
  <el-row>
    <el-col :span="16" :offset="3">
      <el-form-item :label="labelName">
        <slot></slot>
      </el-form-item>
    </el-col>
  </el-row>
</template>

<script>
  export default {
    name: "EditItem",
    props: {labelName:String}
  }
</script>

<style scoped>

</style>
