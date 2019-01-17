package cn.gsein.system.mapper;

import cn.gsein.common.mapper.BaseMapper;
import cn.gsein.system.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * 权限相关的持久层
 *
 * @author G.Seinfeld
 * @date 2019/1/3
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
    /**
     * 获取一个角色能访问的所有权限
     *
     * @param roleId 角色ID
     * @return 角色能访问的所有权限
     */
    List<Permission> getPermissionsByRoleId(Integer roleId);

    /**
     * 获取多个角色能访问的全部权限集合
     *
     * @param roleIds 角色ID列表
     * @return 多个角色能访问的所有权限集合
     */
    Set<Permission> getPermissionsByRoleIds(List<Integer> roleIds);
}
