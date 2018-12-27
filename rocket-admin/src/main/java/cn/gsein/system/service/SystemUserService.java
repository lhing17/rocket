package cn.gsein.system.service;

import cn.gsein.system.entity.SystemUser;

/**
 * 系统用户相关的业务层
 *
 * @author G.Seinfeld
 * @date 2018/12/26
 */
public interface SystemUserService {

    /**
     * 根据用户名获取系统用户，注意用户名是唯一的，因此获取到的用户也是唯一的
     *
     * @param username 用户名
     * @return 系统用户
     */
    SystemUser getUserByUsername(String username);

    /**
     * 将用户密码加密后将用户信息存入数据库中
     * @param user 前端传递过来的用户信息
     * @return 是否保存成功
     */
    int saveUser(SystemUser user);

    /**
     * 更新用户的密码
     * @param username 用户名
     * @param password 密码
     * @return 是否更新成功，更新成功返回1，否则返回0
     */
    int updatePassword(String username, String password);
}
