package cn.gsein.system.mapper;

import cn.gsein.system.entity.UserRole;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * 用户-角色关系持久层测试类
 *
 * @author G.Seinfeld
 * @date 2019/1/3
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRoleMapperTest {

    @Resource
    UserRoleMapper userRoleMapper;

    /**
     * 测试保存用户-角色关系
     */
    @Test
    @Transactional
    public void save() {
        UserRole userRole = new UserRole();
        userRole.setUserId(1);
        userRole.setRoleId(1);
        int result = userRoleMapper.save(userRole);
        Assertions.assertThat(result).isEqualTo(1);
    }

    /**
     * 测试删除用户-角色关系
     */
    @Test
    @Transactional
    public void deleteByUserId() {
        int result = userRoleMapper.deleteByUserId(1);
        Assertions.assertThat(result).isEqualTo(2);
    }
}