package cn.gsein.system.mapper;

import cn.gsein.system.entity.SystemUser;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
    public void getUserByUsernameExists() {
        SystemUser systemUser = systemUserMapper.getUserByUsername("g_seinfeld");
        Assertions.assertThat(systemUser).hasFieldOrPropertyWithValue("id", 1);
    }

    /**
     * 测试用户不存在的场景
     */
    @Test
    public void getUserByUsernameNotExists() {
        SystemUser systemUser = systemUserMapper.getUserByUsername("sisi");
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
                        .username("sisisi")
                        .password("123456")
                        .mobile("13356985462")
                        .deptId(1)
                        .status(0)
                        .build();
        int result = systemUserMapper.save(systemUser);
        Assertions.assertThat(result).isEqualTo(1);

    }
}