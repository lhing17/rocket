<!--
如何使用？
1.导入并添加components, import ToolBar from '~/components/ToolBar/ToolBar.vue',
2.绑定你的api、参数和数据处理函数，会自动生成分页
<Paginator
    api="postList"
    :params="params"
    :refresh="refresh"
    @val-change="PaginateData"
    >
</Paginator>
3.当你再次改动参数时，执行 refresh=!refresh 即可刷新。用于搜索。

-->

<template>
  <div class="pagination">
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[2, 10, 20, 50, 100]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
  </div>
</template>
<script>
  import axios from 'axios';

  export default {
    name: 'Paginator',
    props: {
      listUrl: String,
      api: String,
      params: Object,
      refresh: Boolean,
    },
    data() {
      return {
        total: 40,
        currentPage: 1,
        pageSize: 10,
        listData: []
      }
    },
    methods: {
      paginate: function () {
        axios.get(`${this.listUrl}?current=${this.currentPage}&pageSize=${this.pageSize}`)
          .then(resp => {
            if (resp.data && resp.data.code === '200') {
              console.log(resp.data);
              this.$emit('paginatorToParent', resp.data.data.list);
              this.total = resp.data.data.total;
              this.currentPage = resp.data.data.pageNum;
              this.pageSize = resp.data.data.pageSize;
            } else {
              this.listData = null;
            }
          });
      },
      handleSizeChange(val) {
        this.pageSize = val;
        this.paginate();
      },
      handleCurrentChange: function (page) {
        this.currentPage = page;
        this.paginate();
      }
    },
    watch: {
      'refresh': {
        handler: function () {
          this.currentPage = 0;
          this.paginate();
        },
        // 深度观察
        deep: true
      }
    },
    mounted: function () {
      this.paginate();
    },
  }
</script>
<style lang="less" scoped>
  .pagination {
    padding: 7px;
    border: 1px solid #ebeef5;
    background: #fff;
    text-align: center;
  }

  .total {
    float: left;
    margin-top: 8px;
    margin-left: 10px;
    font-size: 13px;
    color: #606266;
  }
</style>
