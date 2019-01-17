import request from '@/utils/request'
import qs from 'qs'

export default {
  saveUser: (user) =>
    request({
      url: '/system/user/save',
      method: 'post',
      data: qs.stringify(user)
    }),
  updateUser: (user) =>
    request({
      url: '/system/user/update?' + qs.stringify(user),
      method: 'put',
    }),
  resetPassword: (userId) =>
    request({
      url: '/system/user/resetPassword?' + qs.stringify({userId: userId}),
      method: 'put'
    }),

};
