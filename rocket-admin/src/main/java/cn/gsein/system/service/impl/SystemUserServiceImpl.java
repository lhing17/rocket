package cn.gsein.system.service.impl;

import cn.gsein.common.config.CryptoConfigProperties;
import cn.gsein.common.util.ShiroUtil;
import cn.gsein.system.entity.SystemUser;
import cn.gsein.system.mapper.SystemUserMapper;
import cn.gsein.system.service.SystemUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
        return systemUserMapper.getByUsername(username);
    }

    /**
     * 根据ID获取系统用户
     * @param userId 用户ID
     * @return 系统用户
     */
    @Override
    public SystemUser getUserById(Integer userId){
        return systemUserMapper.getById(userId);
    }

    /**
     * 将用户密码加密后将用户信息存入数据库中
     *
     * @param user 前端传递过来的用户信息
     * @return 是否保存成功，保存成功返回1，否则返回0
     */
    @Override
    public int saveUser(SystemUser user) {
        /*
         *密码加密
         */
        String salt = ShiroUtil.generateSalt(cryptoConfigProperties);
        user.setSalt(salt);
        user.setPassword(ShiroUtil.hashPassword(cryptoConfigProperties, user.getPassword(), salt));

        return systemUserMapper.save(user);
    }


    /**
     * 更新用户的密码
     *
     * @param username 用户名
     * @param password 密码
     * @return 是否更新成功，更新成功返回1，否则返回0
     */
    @Override
    public int updatePassword(String username, String password) {
        SystemUser user = new SystemUser();
        user.setUsername(username);
        String salt = ShiroUtil.generateSalt(cryptoConfigProperties);
        user.setSalt(salt);
        user.setPassword(ShiroUtil.hashPassword(cryptoConfigProperties, password, salt));
        return systemUserMapper.updateByUsername(user);
    }

    /**
     * 获取系统用户的分页列表信息
     *
     * @param current  当前页码
     * @param pageSize 每页条数
     * @return 系统用户的分页列表信息
     */
    @Override
    public PageInfo<SystemUser> getUserPageInfo(Integer current, Integer pageSize) {
        PageHelper.startPage(current, pageSize);

        // 构造查询参数
        Map<String, Object> conditions = new HashMap<>();

        return new PageInfo<>(systemUserMapper.getByConditions(conditions));

    }
}
