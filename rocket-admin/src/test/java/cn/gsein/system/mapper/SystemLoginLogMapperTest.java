package cn.gsein.system.mapper;

import cn.gsein.system.entity.SystemLoginLog;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * 系统登录日志的持久化层测试类
 *
 * @author G.Seinfeld
 * @date 2018/12/27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SystemLoginLogMapperTest {

    @Resource
    private SystemLoginLogMapper systemLoginLogMapper;

    /**
     * 测试保存系统登陆日志
     */
    @Transactional
    @Test
    public void save() {
        SystemLoginLog systemLoginLog = new SystemLoginLog();
        systemLoginLog.setUsername("g_seinfeld");
        systemLoginLog.setLoginIp("10.100.9.104");
        systemLoginLog.setLoginTime(new Date());
        systemLoginLog.setIsSuccess(1);
        systemLoginLog.setLoginInfo("登陆成功测试");
        int result = systemLoginLogMapper.save(systemLoginLog);
        Assertions.assertThat(result).isEqualTo(1);
    }
}