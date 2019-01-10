import request from '@/utils/request'
import qs from 'qs'

export default {
  saveUser: (user) =>
    request({
      url: '/system/user/save',
      method: 'post',
      data: qs.stringify(user)
    }),
};
