package cn.gsein.common.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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
    private final static String AUTHENTICATION_QUERY = "select password from sys_user where username = ?";

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
        return shiroFilterFactoryBean;
    }

    /**
     * Shiro认证的数据来源
     *
     * @return 认证数据源的Bean
     */
    @Bean
    public Realm customRealm(DataSource dataSource) {
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(dataSource);
        realm.setAuthenticationQuery(AUTHENTICATION_QUERY);
        return realm;
    }


}
