<template>
  <div class="user-dialog">
    <el-dialog width="30%" :title="title" :visible="dialogFormVisible" @close="dialogFormVisible=false">
      <el-form :model="form" label-width="80px">
        <edit-item label-name="用户名">
          <el-input v-model="form.username"></el-input>
        </edit-item>
        <edit-item label-name="昵称">
          <el-input v-model="form.nickname"></el-input>
        </edit-item>
        <edit-item label-name="性别">
          <el-radio-group v-model="form.gender" size="">
            <el-radio :label="1">男</el-radio>
            <el-radio :label="0">女</el-radio>
          </el-radio-group>
        </edit-item>
        <edit-item label-name="电子邮箱">
          <el-input v-model="form.email"></el-input>
        </edit-item>
        <edit-item label-name="手机号码">
          <el-input v-model="form.mobile"></el-input>
        </edit-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="$emit('cancel')">取 消</el-button>
        <el-button type="primary" :loading="btnLoading" @click="btnOk">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

  import EditItem from '../../components/EditItem';

  export default {
    name: "UserEdit",
    props: {
      dialogFormVisible: Boolean,
      title: String
    },
    data() {
      return {
        form: {username: '', nickname: '', gender: 0, email: '', mobile: ''}
      }
    },
    components: {
      EditItem
    }
  }

</script>

<style scoped>

</style>
