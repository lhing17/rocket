package cn.gsein.system.mapper;

import cn.gsein.system.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * 菜单相关的持久层
 *
 * @author G.Seinfeld
 * @date 2019/1/3
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 获取一个角色能访问的所有菜单
     * @param roleId 角色ID
     * @return 角色能访问的所有菜单
     */
    List<Menu> getMenusByRoleId(Integer roleId);

    /**
     * 获取多个角色能访问的全部菜单集合
     * @param roleIds 角色ID列表
     * @return 多个角色能访问的所有菜单集合
     */
    Set<Menu> getMenusByRoleIds(List<Integer> roleIds);
}
