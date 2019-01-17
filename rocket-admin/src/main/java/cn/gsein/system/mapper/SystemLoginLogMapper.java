package cn.gsein.system.mapper;

import cn.gsein.common.mapper.BaseMapper;
import cn.gsein.system.entity.SystemLoginLog;
import org.springframework.stereotype.Repository;

/**
 * 系统登录日志的持久化层
 *
 * @author G.Seinfeld
 * @date 2018/12/27
 */
@Repository
public interface SystemLoginLogMapper extends BaseMapper<SystemLoginLog> {

}
