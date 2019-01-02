import axios from 'axios'
import Config from '../config/'



const service = axios.create({
  baseURL: '', // api的base_url
  headers: {
    'Accept': '*/*'
  },
  timeout: Config.timeout // 请求超时时间
});

// request拦截器
service.interceptors.request.use(
  config => {
    return config
  },
  error => {
    return Promise.reject(error)
  }
);

// response拦截器
service.interceptors.response.use(
  response => {
    // 5009 用户未登录
    if (response.data.code === '5009') {
      this.$router.push({
        path: "/login",
        // 从哪个页面跳转
        query: {redirect: this.$router.currentRoute.fullPath}
      })
    }
    return response;
  },
  error => {
    console.log(error);
    return Promise.reject(error)
  });

export default service
