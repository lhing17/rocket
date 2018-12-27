package cn.gsein.system.service;

import cn.gsein.system.entity.SystemLoginLog;

/**
 * 记录系统登录日志的服务层
 *
 * @author G.Seinfeld
 * @date 2018/12/27
 */
public interface SystemLoginLogService {

    /**
     * 保存登录日志
     *
     * @param loginLog 登录日志
     * @return 保存成功返回1，否则返回0
     */
    int saveLoginLog(SystemLoginLog loginLog);
}
