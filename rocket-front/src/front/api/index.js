import login from './login';
import saveUser from './user'

let allApi = Object.assign(
  login,
  saveUser
);

export default allApi;
