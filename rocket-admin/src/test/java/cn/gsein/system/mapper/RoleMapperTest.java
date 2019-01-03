package cn.gsein.system.mapper;

import cn.gsein.system.entity.Role;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * 角色持久层测试类
 *
 * @author G.Seinfeld
 * @date 2019/1/3
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleMapperTest {

    @Resource
    RoleMapper roleMapper;

    /**
     * 测试根据用户ID获取所有角色
     */
    @Test
    public void getRolesByUserId() {
        List<Role> roles = roleMapper.getRolesByUserId(1);
        Assertions.assertThat(roles.size()).isEqualTo(2);
        Assertions.assertThat(roles).extracting("id").containsExactly(1, 3);
    }

    /**
     * 测试保存角色
     */
    @Test
    @Transactional
    public void save() {
        Role role = new Role();
        role.setName("管理员");
        role.setDescription("拥有使用一切菜单和功能的权限");
        int result = roleMapper.save(role);
        Assertions.assertThat(result).isEqualTo(1);
    }

    /**
     * 测试修改角色
     */
    @Test
    @Transactional
    public void update() {
        Role role = roleMapper.getById(1);
        role.setName("超级管理员");
        int result = roleMapper.update(role);
        Assertions.assertThat(result).isEqualTo(1);
    }

    /**
     * 测试删除角色
     */
    @Test
    @Transactional
    public void deleteById() {
        int result = roleMapper.deleteById(1);
        Assertions.assertThat(result).isEqualTo(1);
    }
}