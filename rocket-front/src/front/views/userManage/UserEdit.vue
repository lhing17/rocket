<template>
  <div class="user-dialog">
    <el-dialog width="30%" :title="title" :visible="dialogFormVisible" :show-close="false">
      <el-form :model="form" :rules="rules" label-width="80px" ref="form">
        <edit-item label-name="用户名" prop-name="username">
          <el-input v-model="form.username" :disabled="disabled"></el-input>
        </edit-item>
        <edit-item label-name="昵称" prop-name="nickname">
          <el-input v-model="form.nickname"></el-input>
        </edit-item>
        <edit-item label-name="性别" prop-name="gender">
          <el-radio-group v-model="form.gender">
            <el-radio :label="1">男</el-radio>
            <el-radio :label="0">女</el-radio>
          </el-radio-group>
        </edit-item>
        <edit-item label-name="电子邮箱" prop-name="email">
          <el-input v-model="form.email"></el-input>
        </edit-item>
        <edit-item label-name="手机号码" prop-name="mobile">
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
      title: String,
      data: [Object, Boolean]
    },
    data() {
      return {
        disabled: false,
        btnLoading: false,
        form: {id: null, username: '', nickname: '', gender: 0, email: '', mobile: ''},
        rules: {
          username:
            [
              {required: true, message: '用户名不能为空', trigger: 'blur'},
              {max: 15, message: '用户名过长', trigger: 'blur'}
            ],
          email: {type: 'email', message: '请输入正确的邮箱', trigger: 'blur'},
          mobile: {pattern: /^\d{11}$/, message: '请输入正确的手机号', trigger: 'blur'}
        }
      }
    },
    watch: {
      'data': {
        handler: function () {
          if (this.data) {
            for (let k in this.form) {
              this.form[k] = this.data[k];
            }
            this.disabled = true;
          } else {
            for (let k in this.form) {
              this.form[k] = '';
            }
            this.disabled = false;
          }
        },
        deep: true
      }
    },
    methods: {
      btnOk() {
        this.$refs.form.validate(
          valid => {
            if (valid) {
              this.$emit('val-change', this.form)
            } else {
              console.log('验证失败');
              return false;
            }
          }
        );

      }
    },
    components: {
      EditItem
    }
  }

</script>

<style scoped>

</style>
