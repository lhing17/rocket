import request from '@/utils/request'
import qs from 'qs'

export default {
  login: (username, password) =>
    request({
      url: '/system/login',
      method: 'post',
      data: qs.stringify({
        username,
        password
      })
    })
};
