package cn.gsein.system.service;

import cn.gsein.system.entity.SystemUser;
import com.github.pagehelper.PageInfo;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 系统用户服务层测试
 *
 * @author G.Seinfeld
 * @date 2018/12/26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SystemUserServiceTest {

    @Resource
    private SystemUserService systemUserService;

    /**
     * 测试用户存在的场景
     */
    @Test
    public void getUserByUserNameExists() {
        SystemUser systemUser = systemUserService.getUserByUsername("g_seinfeld");
        Assertions.assertThat(systemUser).hasFieldOrPropertyWithValue("id", 1);
    }

    /**
     * 测试用户不存在的场景
     */
    @Test
    public void getUserByUserNameNotExists() {
        SystemUser systemUser = systemUserService.getUserByUsername("no_seinfeld");
        Assertions.assertThat(systemUser).isNull();
    }

    /**
     * 测试保存用户的方法，注意查看密码是否加密
     */
    @Transactional
    @Test
    public void saveUser() {
        SystemUser systemUser =
                SystemUser.builder()
                        .username("no_seinfeld")
                        .password("123456")
                        .mobile("13356985462")
                        .deptId(1)
                        .status(0)
                        .build();
        int result = systemUserService.saveUser(systemUser);
        Assertions.assertThat(result).isEqualTo(1);
    }

    /**
     * 测试更新用户的方法
     */
    @Transactional
    @Test
    public void updateUser(){
        SystemUser systemUser = SystemUser.builder()
                .id(1)
                .mobile("13253392599")
                .email("seinfeld@gmail.com")
                .build();
        int result = systemUserService.updateUser(systemUser);
        Assertions.assertThat(result).isEqualTo(1);

        SystemUser nowUser = systemUserService.getUserById(1);
        Assertions.assertThat(nowUser).hasFieldOrPropertyWithValue("mobile", "13253392599");
        Assertions.assertThat(nowUser).hasFieldOrPropertyWithValue("email", "seinfeld@gmail.com");
    }

    /**
     * 测试修改用户密码的方法
     */
    @Test
    @Transactional
    public void updatePassword() {
        int result = systemUserService.updatePassword("g_seinfeld", "654321");
        Assertions.assertThat(result).isEqualTo(1);
    }

    /**
     * 测试获取用户分页信息
     */
    @Test
    public void getUserPageInfo() {
        PageInfo<SystemUser> pageInfo = systemUserService.getUserPageInfo(1, 2);
        Assertions.assertThat(pageInfo).hasFieldOrPropertyWithValue("pageNum", 1);
        Assertions.assertThat(pageInfo).hasFieldOrPropertyWithValue("pageSize", 2);
        Assertions.assertThat(pageInfo.getList()).extracting("id").containsOnly(1, 11);

    }
}