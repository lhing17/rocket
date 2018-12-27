package cn.gsein.system.entity;

import lombok.Data;

import java.util.Date;

/**
 * 系统登录日志
 *
 * @author G.Seinfeld
 * @date 2018/12/27
 */
@Data
public class SystemLoginLog {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 登录用户名，这里不用ID是因为可能有不存在的用户名登录
     */
    private String username;
    /**
     * 登录IP
     */
    private String loginIp;
    /**
     * 登录时间
     */
    private Date loginTime;
    /**
     * 是否登录成功 0-失败 1-成功
     */
    private Integer isSuccess;
    /**
     * 登录信息，记录登录失败原因等
     */
    private String loginInfo;
}
