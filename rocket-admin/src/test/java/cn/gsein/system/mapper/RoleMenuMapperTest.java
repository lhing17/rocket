package cn.gsein.system.mapper;

import cn.gsein.system.entity.RoleMenu;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 菜单-角色对应关系持久层测试类
 *
 * @author G.Seinfeld
 * @date 2019/1/3
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleMenuMapperTest {

    @Resource
    RoleMenuMapper roleMenuMapper;

    /**
     * 测试保存菜单-角色对应关系
     */
    @Test
    public void save() {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setRoleId(1);
        roleMenu.setMenuId(1);
        int result = roleMenuMapper.save(roleMenu);
        Assertions.assertThat(result).isEqualTo(1);
    }

    /**
     * 测试根据角色ID删除所有角色-菜单关系
     */
    @Test
    @Transactional
    public void deleteByRoleId() {
        int result = roleMenuMapper.deleteByRoleId(1);
        Assertions.assertThat(result).isEqualTo(2);
    }
}