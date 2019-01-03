package cn.gsein.system.mapper;

import cn.gsein.system.entity.SystemUser;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 用户持久层测试类
 *
 * @author G.Seinfeld
 * @date 2018/12/26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SystemUserMapperTest {

    @Resource
    SystemUserMapper systemUserMapper;

    /**
     * 测试用户存在的场景
     */
    @Test
    public void getByUsernameExists() {
        SystemUser systemUser = systemUserMapper.getByUsername("g_seinfeld");
        Assertions.assertThat(systemUser).hasFieldOrPropertyWithValue("id", 1);
    }

    /**
     * 测试用户存在的场景
     */
    @Test
    public void getByIdExists() {
        SystemUser systemUser = systemUserMapper.getById(1);
        Assertions.assertThat(systemUser).hasFieldOrPropertyWithValue("username", "g_seinfeld");
    }

    /**
     * 测试用户不存在的场景
     */
    @Test
    public void getByUsernameNotExists() {
        SystemUser systemUser = systemUserMapper.getByUsername("no_seinfeld");
        Assertions.assertThat(systemUser).isNull();
    }

    /**
     * 测试用户不存在的场景
     */
    @Test
    public void getByIdNotExists() {
        SystemUser systemUser = systemUserMapper.getById(4);
        Assertions.assertThat(systemUser).isNull();
    }

    /**
     * 测试保存用户的场景
     */
    @Test
    @Transactional
    public void saveUser() {
        SystemUser systemUser =
                SystemUser.builder()
                        .username("no_seinfeld")
                        .password("123456")
                        .mobile("13356985462")
                        .deptId(1)
                        .status(0)
                        .build();
        int result = systemUserMapper.save(systemUser);
        Assertions.assertThat(result).isEqualTo(1);
    }

    /**
     * 测试更新用户信息的场景
     */
    @Test
    @Transactional
    public void updateUser() {
        SystemUser user = systemUserMapper.getByUsername("g_seinfeld");
        user.setMobile("17549546646");
        user.setStatus(1);
        int result = systemUserMapper.updateByUsername(user);
        Assertions.assertThat(result).isEqualTo(1);
    }

    /**
     * 测试删除用户信息的场景
     */
    @Test
    @Transactional
    public void deleteByIdExists() {
        Integer userId = 1;
        int result = systemUserMapper.deleteById(userId);
        SystemUser systemUser = systemUserMapper.getById(1);
        Assertions.assertThat(result).isEqualTo(1);
        Assertions.assertThat(systemUser).isNull();
    }
    /**
     * 测试删除用户信息不存在的场景
     */
    @Test
    @Transactional
    public void deleteByIdNotExists() {
        Integer userId = 4;
        int result = systemUserMapper.deleteById(userId);
        Assertions.assertThat(result).isEqualTo(0);
    }

    /**
     * 测试根据条件查询
     */
    @Test
    public void getByConditions() {
        List<SystemUser> systemUserList = systemUserMapper.getByConditions(new HashMap<>());
        Assertions.assertThat(systemUserList.size()).isEqualTo(3);
        Assertions.assertThat(systemUserList).extracting("id").contains(1, 11, 16);
    }
}