<template>
  <div class="user-list">
    <ToolBar>
      <el-button type="primary" icon="el-icon-plus" size="small" @click="editUser(false)">添加</el-button>
      <div style="float: right">
        <el-input
          placeholder="请输入用户昵称！"
          size="small"
          style="width: 140px"
          v-model="params.name"
          @clear="searchUser"
          clearable>
        </el-input>
        <el-button @click="searchUser" type="success" icon="el-icon-search" size="small"></el-button>
      </div>
    </ToolBar>
    <el-table
      :data="listData"
      border
      ref="table"
      style="width: 100%">
      <el-table-column
        prop="username"
        label="登录账号">
      </el-table-column>
      <el-table-column
        prop="nickname"
        label="昵称">
      </el-table-column>
      <el-table-column
        prop="email"
        label="邮箱">
      </el-table-column>
      <el-table-column
        prop="mobile"
        label="手机">
      </el-table-column>
      <el-table-column
        prop="sex"
        width="66"
        label="性别">
        <div slot-scope="scope" style="width: 100%;text-align: center">{{ $Config.sex[scope.row.gender] }}</div>
      </el-table-column>
      <el-table-column
        prop="status"
        width="100"
        label="状态">
        <div slot-scope="scope" style="width: 100%;text-align: center">
          <el-tag v-if="scope.row.status" type="danger">锁定</el-tag>
          <el-tag v-else>正常</el-tag>
        </div>
      </el-table-column>
      <el-table-column
        label="操作"
        :render-header="tableAction"
        width="180">
        <template slot-scope="scope">
          <el-button @click="resetting(scope.row.id)" type="warning" style="transition: .4s;" :ref="scope.row.id"
                     icon="el-icon-refresh" size="small" circle></el-button>
          <el-button @click="editUser(scope.row)" type="primary" icon="el-icon-edit" size="small" circle></el-button>
          <el-button @click="deleteUser(scope.row.id)" v-if="scope.row.active != '0'" type="danger"
                     icon="el-icon-delete" circle size="small"></el-button>
          <el-button @click="deleteUser(scope.row.id)" v-else icon="el-icon-check" circle size="small"></el-button>
        </template>
      </el-table-column>
    </el-table>
    <Paginator ref="paginator" list-url="/system/user/list" @paginatorToParent="receiveData"></Paginator>
    <user-edit
      :title="userEdit"
      :dialogFormVisible="dialogFormVisible"
      @cancel="dialogFormVisible = false"
      @val-change="saveUser"
    >

    </user-edit>
  </div>
</template>

<script>
  import ToolBar from '@/components/ToolBar.vue';
  import HelpHint from '@/components/HelpHint.vue';

  import Paginator from "../../components/Paginator";
  import UserEdit from './UserEdit'


  export default {

    data() {
      return {
        params: {
          name: '',
        },
        listData: [],
        userEdit: '编辑用户',
        dialogFormVisible: false
      }
    },
    methods: {
      receiveData(data) {
        this.listData = data;
      },
      searchUser() {
        let tableRow = this.$refs.table.$el.querySelectorAll('tbody tr');
        let tableRowHeight = tableRow[1].offsetHeight;
        let isjump = false;
        for (let i = 0; i < this.listData.length; i++) {
          if (this.params.name && this.listData[i].nickname.indexOf(this.params.name) !== -1) {
            tableRow[i].style.backgroundColor = '#85ce61';
            if (!isjump) {
              scrollTo(0, i * tableRowHeight + 66);
              isjump = true;

            }
          } else {
            tableRow[i].style.backgroundColor = '#fff';
          }
        }
      },
      tableAction() {
        return this.$createElement('HelpHint', {
          props: {
            content: '重置密码为123456 / 编辑用户 / 删除或恢复用户'
          }
        }, '操作');
      },
      editUser(data) {
        this.dialogFormVisible = true;
      },
      saveUser(data) {
        this.$Api.saveUser(data).then(resp => {
          if (resp.data && resp.data.code === '200'){
            this.$refs.paginator.paginate();
          }
          console.log(resp);
          this.dialogFormVisible = false;
        })
      },
      UploadUser(data) {

      },
      deleteUser(id) {

        this.$message({
          message: '这里请求api删除或者恢复用户之后刷新分页组件，列表自动更新',
          type: 'success'
        });

      },
      resetting(id) {

        let dom = this.$refs[id].$el;
        dom.style.transform = 'rotate(180deg)';
        setTimeout(() => {
          dom.style.transform = 'rotate(0deg)'
        }, 600);
        this.$message({
          message: '已经成功重置密码',
          type: 'success'
        });

      },


    },
    components: {
      Paginator, ToolBar, HelpHint, UserEdit
    }
  }
</script>
<style lang="less">

</style>
