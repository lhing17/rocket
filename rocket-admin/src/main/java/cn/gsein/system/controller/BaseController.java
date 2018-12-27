package cn.gsein.system.controller;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller的基类，所有Controller类必须继承此类
 *
 * @author G.Seinfeld
 * @date 2018/12/25
 */
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 获取登录用户的用户名
     * @return 用户名，未登录则返回null
     */
    public String getLoginUsername(){
        return (String) SecurityUtils.getSubject().getPrincipal();
    }
}
