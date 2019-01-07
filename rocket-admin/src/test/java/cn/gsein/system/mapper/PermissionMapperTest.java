package cn.gsein.system.mapper;

import cn.gsein.system.entity.Permission;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;


/**
 * 权限持久层测试类
 *
 * @author G.Seinfeld
 * @date 2019/1/7
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PermissionMapperTest {

    @Resource
    PermissionMapper permissionMapper;

    /**
     * 测试保存权限
     */
    @Test
    @Transactional
    public void save() {
        Permission permission = new Permission();
        permission.setMenuId(2);
        permission.setName("查看");
        permission.setLabel("system:user:save");
        permission.setDescription("查看用户菜单的权限");

        int result = permissionMapper.save(permission);
        Assertions.assertThat(result).isEqualTo(1);
    }

    /**
     * 测试根据ID获取权限
     */
    @Test
    public void getById() {
        Permission permission = permissionMapper.getById(1);
        Assertions.assertThat(permission).hasFieldOrPropertyWithValue("menuId", 2);
        Assertions.assertThat(permission).hasFieldOrPropertyWithValue("name", "查看");
        Assertions.assertThat(permission).hasFieldOrPropertyWithValue("label", "system:user:save");
    }

    /**
     * 测试更新权限
     */
    @Test
    @Transactional
    public void update() {
        Permission permission = permissionMapper.getById(1);
        permission.setMenuId(3);
        int result = permissionMapper.update(permission);
        Assertions.assertThat(result).isEqualTo(1);

        Permission newPermission = permissionMapper.getById(1);
        Assertions.assertThat(newPermission.getMenuId()).isEqualTo(3);
    }

    /**
     * 测试根据ID删除权限
     */
    @Test
    @Transactional
    public void deleteById() {
        int result = permissionMapper.deleteById(1);
        Assertions.assertThat(result).isEqualTo(1);

        Permission permission = permissionMapper.getById(1);
        Assertions.assertThat(permission).isNull();
    }

    /**
     * 测试根据角色ID获得权限列表
     */
    @Test
    public void getPermissionsByRoleId() {
        List<Permission> permissions = permissionMapper.getPermissionsByRoleId(1);
        Assertions.assertThat(permissions.size()).isEqualTo(2);
        Assertions.assertThat(permissions).extracting("id").containsOnly(1, 2);
    }

    /**
     * 测试根据角色ID列表获取权限集合
     */
    @Test
    public void getPermissionsByRoleIds() {
        Set<Permission> permissions = permissionMapper.getPermissionsByRoleIds(Lists.newArrayList(1, 3));
        Assertions.assertThat(permissions.size()).isEqualTo(3);
        Assertions.assertThat(permissions).extracting("id").containsOnly(1, 2, 3);
    }
}