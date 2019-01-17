package cn.gsein.system.mapper;

import cn.gsein.common.mapper.BaseMapper;
import cn.gsein.system.entity.UserRole;
import org.springframework.stereotype.Repository;

/**
 * 用户-角色关联持久层
 *
 * @author G.Seinfeld
 * @date 2019/1/3
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {
    /**
     * 根据用户ID删除用户所有角色
     *
     * @param userId 用户ID
     * @return 删除成功返回一个正整数，否则返回0
     */
    int deleteByUserId(Integer userId);
}
