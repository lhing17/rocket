package cn.gsein.system.service;

import cn.gsein.system.entity.SystemLoginLog;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 系统登陆日志服务层测试类
 *
 * @author G.Seinfeld
 * @date 2018/12/27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SystemLoginLogServiceTest {

    @Resource
    private SystemLoginLogService systemLoginLogService;

    /**
     * 测试保存系统登陆日志
     */
    @Test
    @Transactional
    public void saveLoginLog() {
        SystemLoginLog systemLoginLog = new SystemLoginLog();
        systemLoginLog.setUsername("g_seinfeld");
        systemLoginLog.setLoginIp("10.100.9.104");
        systemLoginLog.setLoginTime(new Date());
        systemLoginLog.setIsSuccess(1);
        systemLoginLog.setLoginInfo("登陆成功测试");
        int result = systemLoginLogService.saveLoginLog(systemLoginLog);
        Assertions.assertThat(result).isEqualTo(1);
    }
}