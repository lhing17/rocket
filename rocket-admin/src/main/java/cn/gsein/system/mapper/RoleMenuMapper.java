package cn.gsein.system.mapper;

import cn.gsein.system.entity.RoleMenu;
import org.springframework.stereotype.Repository;

/**
 * 角色-菜单关系持久层
 *
 * @author G.Seinfeld
 * @date 2019/1/3
 */
@Repository
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    /**
     * 根据角色ID删除所有角色-菜单关系
     *
     * @param roleId 角色ID
     * @return 删除成功返回一个正整数，否则返回0
     */
    int deleteByRoleId(Integer roleId);
}
