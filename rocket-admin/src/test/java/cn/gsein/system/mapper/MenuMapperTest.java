package cn.gsein.system.mapper;

import cn.gsein.system.entity.Menu;
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
 * 菜单持久层的测试类
 *
 * @author G.Seinfeld
 * @date 2019/1/3
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MenuMapperTest {

    @Resource
    MenuMapper menuMapper;

    /**
     * 测试获取一个角色能访问的所有菜单
     */
    @Test
    public void getMenusByRoleId() {
        List<Menu> menus = menuMapper.getMenusByRoleId(3);
        Assertions.assertThat(menus.size()).isEqualTo(2);
        Assertions.assertThat(menus).extracting("id").containsExactly(2, 3);
    }

    /**
     * 测试获取多个角色能访问的所有菜单集合
     */
    @Test
    public void getMenusByRoleIds() {
        Set<Menu> menus = menuMapper.getMenusByRoleIds(Lists.newArrayList(1, 3));
        Assertions.assertThat(menus.size()).isEqualTo(3);
        Assertions.assertThat(menus).extracting("id").containsOnly(1, 2, 3);
    }

    /**
     * 测试根据ID获取菜单
     */
    @Test
    public void getById() {
        Menu menu = menuMapper.getById(1);
        Assertions.assertThat(menu).hasFieldOrPropertyWithValue("name", "用户管理");
        Assertions.assertThat(menu).hasFieldOrPropertyWithValue("enabled", 1);
        Assertions.assertThat(menu).hasFieldOrPropertyWithValue("pid", null);
    }

    /**
     * 测试保存菜单
     */
    @Test
    @Transactional
    public void save() {
        Menu menu = Menu.builder()
                .name("用户列表")
                .description("用户列表菜单")
                .enabled(1)
                .icon("fa fa-user-circle-o")
                .pid(1)
                .url("/system/user_list")
                .build();
        int result = menuMapper.save(menu);
        Assertions.assertThat(result).isEqualTo(1);
    }

    /**
     * 测试更新菜单
     */
    @Test
    @Transactional
    public void update() {
        Menu menu = menuMapper.getById(1);
        menu.setEnabled(0);
        int result = menuMapper.update(menu);
        Assertions.assertThat(result).isEqualTo(1);
    }

    /**
     * 测试删除菜单
     */
    @Test
    @Transactional
    public void deleteById() {
        int result = menuMapper.deleteById(1);
        Assertions.assertThat(result).isEqualTo(1);
        Menu menu = menuMapper.getById(1);
        Assertions.assertThat(menu).isNull();
    }


}