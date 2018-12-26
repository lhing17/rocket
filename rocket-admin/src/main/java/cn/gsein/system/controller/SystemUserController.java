package cn.gsein.system.controller;

import cn.gsein.system.entity.JsonResult;
import cn.gsein.system.entity.SystemUser;
import cn.gsein.system.service.SystemUserService;
import cn.gsein.system.utils.ReturnCode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统用户相关的控制器类
 *
 * @author G.Seinfeld
 * @date 2018/12/26
 */
@RestController
@RequestMapping("/system/user")
public class SystemUserController extends BaseController {

    /**
     * 注入系统用户业务层接口
     */
    @Resource
    private SystemUserService systemUserService;

    /**
     * 新增用户
     *
     * @param user 封装的用户信息
     * @return JSON结果
     */
    @PostMapping("/save")
    public JsonResult save(SystemUser user) {

        // 防御式编程，处理用户名或密码为空的情况
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return JsonResult.error(ReturnCode.EMPTY_USERNAME_OR_PASSWORD);
        }

        // 处理用户名已存在的情况
        SystemUser foundUser = systemUserService.getUserByUsername(user.getUsername());
        if (foundUser != null) {
            return JsonResult.error(ReturnCode.USERNAME_EXISTED);
        }

        // 将用户信息插入数据库
        int result = systemUserService.saveUser(user);

        // 插入数据库失败的情况
        if (result != 1) {
            return JsonResult.error(ReturnCode.USER_SAVE_FAIL);
        }

        return JsonResult.ok();
    }
}
