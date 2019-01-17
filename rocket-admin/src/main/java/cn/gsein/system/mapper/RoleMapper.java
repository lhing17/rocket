package cn.gsein.system.mapper;

import cn.gsein.common.mapper.BaseMapper;
import cn.gsein.system.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色相关的持久层
 *
 * @author G.Seinfeld
 * @date 2019/1/3
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据用户ID获取用户所有的角色
     *
     * @param userId 用户ID
     * @return 用户所有的角色列表
     */
    List<Role> getRolesByUserId(Integer userId);
}
