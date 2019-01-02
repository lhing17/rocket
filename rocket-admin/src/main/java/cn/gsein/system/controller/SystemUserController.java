package cn.gsein.system.controller;

import cn.gsein.common.config.CryptoConfigProperties;
import cn.gsein.common.util.ShiroUtil;
import cn.gsein.system.entity.JsonResult;
import cn.gsein.system.entity.SystemUser;
import cn.gsein.system.service.SystemUserService;
import cn.gsein.system.utils.ReturnCode;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
     * 加密相关配置
     */
    @Resource
    private CryptoConfigProperties cryptoConfigProperties;

    /**
     * 新增用户
     *
     * @param user 封装的用户信息
     * @return JSON结果
     */
    @RequiresPermissions("system:user:save")
    @PostMapping("/save")
    public JsonResult save(SystemUser user) {
        logger.info("请求新增用户，参数为SystemUser: " + user);

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

    /**
     * 修改密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 修改密码的结果
     */
    @PutMapping("/changePassword")
    public JsonResult changePassword(String oldPassword, String newPassword) {
        logger.info("请求修改密码，oldPassword: " + oldPassword + ", newPassword: " + newPassword);
        String username = getLoginUsername();
        // 用户未登录
        if (username == null) {
            return JsonResult.error(ReturnCode.NOT_LOGGING_IN);
        }

        /*
         *判断旧密码是否正确
         */
        SystemUser systemUser = systemUserService.getUserByUsername(username);
        String salt = systemUser.getSalt();
        // 从数据库中取出的加密的密码
        String hashedPassword = systemUser.getPassword();
        // 对用户提供的密码按原规则进行加密
        String hashingPassword = ShiroUtil.hashPassword(cryptoConfigProperties, oldPassword, salt);
        if (!hashedPassword.equals(hashingPassword)) {
            return JsonResult.error(ReturnCode.WRONG_OLD_PASSWORD);
        }

        // 加密新密码并更新数据库
        int result = systemUserService.updatePassword(username, newPassword);

        // 插入数据库失败的情况
        if (result != 1) {
            return JsonResult.error(ReturnCode.PASSWORD_UPDATE_FAIL);
        }

        return JsonResult.ok();
    }

    /**
     * 获取用户列表
     *
     * @param current  当前页数
     * @param pageSize 每页条数
     * @return 用户列表JSON对象
     */
    @RequiresPermissions("system:user:list")
    @GetMapping("/list")
    public JsonResult userList(Integer current, Integer pageSize) {
        PageInfo<SystemUser> pageInfo = systemUserService.getUserPageInfo(current, pageSize);
        if (pageInfo != null) {
            return JsonResult.ok(pageInfo);
        } else {
            return JsonResult.error(ReturnCode.REQUEST_FAIL);
        }
    }
}
