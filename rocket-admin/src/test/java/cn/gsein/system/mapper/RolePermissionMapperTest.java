package cn.gsein.system.mapper;

import cn.gsein.system.entity.RolePermission;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author G.Seinfeld
 * @date 2019/01/07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RolePermissionMapperTest {

    @Resource
    RolePermissionMapper rolePermissionMapper;

    /**
     * 测试保存角色-权限数据
     */
    @Test
    @Transactional
    public void save() {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(1);
        rolePermission.setPermissionId(1);

        int result = rolePermissionMapper.save(rolePermission);
        Assertions.assertThat(result).isEqualTo(1);
    }

    /**
     * 测试根据ID删除所有角色-权限数据
     */
    @Test
    @Transactional
    public void deleteByRoleId(){
        int result = rolePermissionMapper.deleteByRoleId(1);
        Assertions.assertThat(result).isEqualTo(2);
    }
}