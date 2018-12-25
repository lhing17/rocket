package cn.gsein.system.controller;

import cn.gsein.system.entity.JsonResult;
import cn.gsein.system.utils.ReturnCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author G.Seinfeld
 * @date 2018/12/25
 */
@RestController
public class SystemLoginController extends BaseController {

    @RequestMapping("/system/login")
    public JsonResult login(String username, String password, String captcha) {
        logger.info("用户请求登陆，username: " + username + ", password: " + password);
        // 获取用户
        Subject subject = SecurityUtils.getSubject();

        // TODO 校验验证码

        try {
            // 使用前端传来的用户名和密码构造新的用户名密码令牌
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            // 账户不存在
            JsonResult result = JsonResult.error(ReturnCode.NO_ACCOUNT);
            System.out.println(result);
            return result;
        } catch (IncorrectCredentialsException e) {
            // 密码错误
            return JsonResult.error(ReturnCode.WRONG_PASSWORD);
        } catch (LockedAccountException e) {
            // 账户锁定
            return JsonResult.error(ReturnCode.LOCKED_ACCOUNT);
        } catch (AuthenticationException e) {
            // 其他原因导致的账户验证失败
            logger.error("账户验证失败", e);
            return JsonResult.error(ReturnCode.AUTHENTICATION_FAIL);
        }

        return JsonResult.ok();
    }
}
