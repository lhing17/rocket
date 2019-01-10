import request from '@/utils/request'
import qs from 'qs'

export default {
  saveUser: (user) =>
    request({
      url: '/system/user/save',
      method: 'post',
      data: qs.stringify(user)
    }),
  resetPassword: (userId) => {
    console.log(qs.stringify({userId: userId}));
    request({
      url: '/system/user/resetPassword?' + qs.stringify({userId: userId}),
      method: 'put'
    })
  }
};
