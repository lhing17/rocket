package cn.gsein.common.config;

import cn.gsein.common.filter.CustomFormAuthenticationFilter;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Shiro安全框架相关的配置，主要是注册一些Bean，满足必要的配置，或替换掉一些不符合使用场景的缺省配置
 *
 * @author G.Seinfeld
 * @date 2018/12/25
 */
@Configuration
public class ShiroConfig {


    /**
     * 通过数据库查询获取用户的密码（密文）
     */
    private final static String SALTED_AUTHENTICATION_QUERY = "select password, salt from sys_user where username = ?";
    @Resource
    private CryptoConfigProperties cryptoConfigProperties;

    /**
     * 自定义安全管理器
     *
     * @return 安全管理器的Bean
     */
    @Bean
    public SecurityManager securityManager(Realm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm);
        return securityManager;
    }

    /**
     * 注册Shiro的过滤器，并设置安全管理器
     *
     * @param securityManager 安全管理器的Bean
     * @return Shiro过滤器的Bean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 自定义过滤器
        Map<String, Filter> filters = new HashMap<>(16);
        filters.put("authc", new CustomFormAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filters);

        // 权限验证的过滤器链
        Map<String, String> map = new HashMap<>(16);
        map.put("/system/login", "anon");
        map.put("/system/checkLoginStatus", "anon");
        map.put("/generateCaptcha", "anon");
        map.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * Shiro认证的数据来源
     *
     * @return 认证数据源的Bean
     */
    @Bean
    public Realm customRealm(DataSource dataSource, CredentialsMatcher credentialsMatcher) {
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(dataSource);
        realm.setSaltStyle(JdbcRealm.SaltStyle.COLUMN);
        realm.setAuthenticationQuery(SALTED_AUTHENTICATION_QUERY);
        realm.setCredentialsMatcher(credentialsMatcher);
        return realm;
    }

    /**
     * 密码匹配器
     *
     * @return 哈希密码匹配器Bean
     */
    @Bean
    public CredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName(cryptoConfigProperties.getAlgorithmName());
        matcher.setHashIterations(cryptoConfigProperties.getHashIterations());
        return matcher;
    }


}
