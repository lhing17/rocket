package cn.gsein.system.controller;

import cn.gsein.common.util.HttpUtil;
import cn.gsein.system.entity.JsonResult;
import cn.gsein.system.entity.SystemLoginLog;
import cn.gsein.system.service.SystemLoginLogService;
import cn.gsein.system.utils.ReturnCode;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * 登录相关的控制器类
 *
 * @author G.Seinfeld
 * @date 2018/12/25
 */
@RestController
public class SystemLoginController extends BaseController {

    /**
     * 图形验证码
     */
    private static final String CAPTCHA = "captcha";
    /**
     * 登录失败次数
     */
    private static final String FAIL_COUNT = "failCount";
    /**
     * 允许无图形验证码登录的次数
     */
    private static final int ALLOWED_FAIL_COUNT = 2;

    /**
     * 验证码生成器
     */
    @Resource
    private DefaultKaptcha defaultKaptcha;

    @Resource
    private SystemLoginLogService systemLoginLogService;

    /**
     * 生成验证码
     *
     * @param session 会话对象
     * @return 封装的JSON对象，包含Base64的验证码图片
     */
    @GetMapping("/generateCaptcha")
    public JsonResult generateCaptcha(HttpSession session) {
        logger.info("请求生成图形验证码，sessionId为" + session.getId());

        // 登录失败三次以内，不需要生成图形验证码
        if (session.getAttribute(FAIL_COUNT) == null || (int) session.getAttribute(FAIL_COUNT) <= ALLOWED_FAIL_COUNT) {
            return JsonResult.error(ReturnCode.NEED_NOT_TO_GENERATE_CAPTCHA);
        }

        // 生成图形验证码的文本和图片，将文本保存到Session中
        String text = defaultKaptcha.createText();
        session.setAttribute(CAPTCHA, text);
        BufferedImage image = defaultKaptcha.createImage(text);

        // try-with-resources语法
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // 将图片写入流中，并转成Base64字符串
            ImageIO.write(image, "jpg", outputStream);
            BASE64Encoder encoder = new BASE64Encoder();
            String captcha = encoder.encode(outputStream.toByteArray());

            return JsonResult.ok(captcha);
        } catch (IOException e) {
            logger.error("生成图形验证码失败", e);
            return JsonResult.error(ReturnCode.CAPTHA_GENERATION_ERROR);
        }
    }

    /**
     * 查询登录状态
     * @param request 请求对象
     * @return 请求结果的JSON对象
     */
    @GetMapping("/system/checkLoginStatus")
    public JsonResult checkLoginStatus(HttpServletRequest request) {
        logger.info("用户请求查询登陆状态，IP地址：" + HttpUtil.getIpAddr(request));
        String username = getLoginUsername();
        if (username == null){
            return JsonResult.error(ReturnCode.NOT_LOGGING_IN);
        }
        return JsonResult.ok(username);
    }

    /**
     * 登录请求
     *
     * @param username 用户名
     * @param password 密码
     * @param captcha  验证码
     * @param request  请求对象
     * @return 登录结果
     */
    @PostMapping("/system/login")
    public JsonResult login(String username, String password, String captcha, HttpServletRequest request) {
        logger.info("用户请求登录，username: " + username + ", password: " + password);
        // 获取用户
        Subject subject = SecurityUtils.getSubject();

        // 通过请求获取session
        HttpSession session = request.getSession();
        // 校验验证码
        if (!StringUtils.isEmpty(session.getAttribute(CAPTCHA))
                && !((String) session.getAttribute(CAPTCHA)).equalsIgnoreCase(captcha)) {
            addFailCount(session);
            return JsonResult.error(ReturnCode.WRONG_CAPTHA);
        }

        try {
            // 使用前端传来的用户名和密码构造新的用户名密码令牌
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            // 账户不存在
            loginFail(ReturnCode.NO_ACCOUNT, username, request);
            return JsonResult.error(ReturnCode.NO_ACCOUNT);
        } catch (IncorrectCredentialsException e) {
            // 密码错误
            loginFail(ReturnCode.WRONG_PASSWORD, username, request);
            return JsonResult.error(ReturnCode.WRONG_PASSWORD);
        } catch (LockedAccountException e) {
            // 账户锁定
            loginFail(ReturnCode.LOCKED_ACCOUNT, username, request);
            return JsonResult.error(ReturnCode.LOCKED_ACCOUNT);
        } catch (AuthenticationException e) {
            // 其他原因导致的账户验证失败
            loginFail(ReturnCode.AUTHENTICATION_FAIL, username, request);
            logger.error("账户验证失败", e);
            return JsonResult.error(ReturnCode.AUTHENTICATION_FAIL);
        }

        // TODO 生成token传递给前台，用于后续无状态的请求

        // 记录成功登录日志
        saveLoginLog(username, request, 1, "登录成功");

        return JsonResult.ok();
    }

    /**
     * 登陆失败的处理
     *
     * @param returnCode 登陆失败对应的返回码
     * @param username   登陆失败的用户名
     * @param request    登陆的请求对象
     */
    private void loginFail(ReturnCode returnCode, String username, HttpServletRequest request) {
        HttpSession session = request.getSession();
        addFailCount(session);
        saveLoginLog(username, request, 0, returnCode.getMessage());
    }

    /**
     * 记录登录日志 TODO 改造成单独线程或消息队列，避免对正常业务造成干扰
     *
     * @param username  用户名
     * @param request   请求
     * @param isSuccess 是否请求成功
     * @param message   请求信息
     */
    private void saveLoginLog(String username, HttpServletRequest request, int isSuccess, String message) {
        SystemLoginLog systemLoginLog = new SystemLoginLog();
        systemLoginLog.setLoginIp(HttpUtil.getIpAddr(request));
        systemLoginLog.setUsername(username);
        systemLoginLog.setLoginTime(new Date());
        systemLoginLog.setIsSuccess(isSuccess);
        systemLoginLog.setLoginInfo(message);
        systemLoginLogService.saveLoginLog(systemLoginLog);
    }


    /**
     * 增加请求失败次数
     *
     * @param session 会话对象
     */
    private void addFailCount(HttpSession session) {
        if (session.getAttribute(FAIL_COUNT) == null) {
            session.setAttribute(FAIL_COUNT, 1);
        } else {
            session.setAttribute(FAIL_COUNT, (int) session.getAttribute(FAIL_COUNT) + 1);
        }
    }
}
