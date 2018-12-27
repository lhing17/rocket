package cn.gsein.system.service.impl;

import cn.gsein.system.entity.SystemLoginLog;
import cn.gsein.system.mapper.SystemLoginLogMapper;
import cn.gsein.system.service.SystemLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 记录系统登录日志的服务层实现类
 *
 * @author G.Seinfeld
 * @date 2018/12/27
 */
@Service
public class SystemLoginLogServiceImpl implements SystemLoginLogService {

    /**
     * 注入登录日志持久层
     */
    @Resource
    private SystemLoginLogMapper systemLoginLogMapper;

    /**
     * 保存登录日志
     *
     * @param loginLog 登录日志
     * @return 保存成功返回1，否则返回0
     */
    @Override
    public int saveLoginLog(SystemLoginLog loginLog) {
        return systemLoginLogMapper.save(loginLog);
    }
}
