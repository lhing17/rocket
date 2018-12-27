package cn.gsein.system.mapper;

import cn.gsein.system.entity.SystemUser;
import org.springframework.stereotype.Repository;

/**
 * 系统用户相关的持久层
 *
 * @author G.Seinfeld
 * @date 2018/12/26
 */
@Repository
public interface SystemUserMapper extends BaseMapper<SystemUser>{
    /**
     * 根据用户名获取系统用户，注意用户名是唯一的，因此获取到的用户也是唯一的
     *
     * @param username 用户名
     * @return 系统用户
     */
    SystemUser getUserByUsername(String username);

}
