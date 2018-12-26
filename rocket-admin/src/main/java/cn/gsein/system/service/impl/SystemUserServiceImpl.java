package cn.gsein.system.service.impl;

import cn.gsein.common.config.CryptoConfigProperties;
import cn.gsein.system.entity.SystemUser;
import cn.gsein.system.mapper.SystemUserMapper;
import cn.gsein.system.service.SystemUserService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 系统用户相关的业务层
 *
 * @author G.Seinfeld
 * @date 2018/12/26
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Resource
    private CryptoConfigProperties cryptoConfigProperties;

    /**
     * 注入持久层接口
     */
    @Resource
    private SystemUserMapper systemUserMapper;

    /**
     * 根据用户名获取系统用户，注意用户名是唯一的，因此获取到的用户也是唯一的
     *
     * @param username 用户名
     * @return 系统用户
     */
    @Override
    public SystemUser getUserByUsername(String username) {
        return systemUserMapper.getUserByUsername(username);
    }

    /**
     * 将用户密码加密后将用户信息存入数据库中
     *
     * @param user 前端传递过来的用户信息
     * @return 是否保存成功
     */
    @Override
    public int saveUser(SystemUser user) {
        /*
         *密码加密
         */
        // 使用随机数生成器生成盐
        // TODO 提取专门的工具类
        RandomNumberGenerator generator = new SecureRandomNumberGenerator();
        String salt = generator.nextBytes(cryptoConfigProperties.getNextBytesSize()).toHex();
        user.setSalt(salt);
        user.setPassword(new SimpleHash(cryptoConfigProperties.getAlgorithmName(),
                user.getPassword(), salt, cryptoConfigProperties.getHashIterations()).toHex());

        return systemUserMapper.save(user);
    }
}
