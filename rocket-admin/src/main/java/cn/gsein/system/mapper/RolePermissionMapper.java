package cn.gsein.system.mapper;

import cn.gsein.common.mapper.BaseMapper;
import cn.gsein.system.entity.RolePermission;
import org.springframework.stereotype.Repository;

/**
 * 角色-权限关系持久层
 *
 * @author G.Seinfeld
 * @date 2019/1/3
 */
@Repository
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    /**
     * 根据角色ID删除所有角色-权限关系
     *
     * @param roleId 角色ID
     * @return 删除成功返回一个正整数，否则返回0
     */
    int deleteByRoleId(Integer roleId);
}
