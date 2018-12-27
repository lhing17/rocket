package cn.gsein.common.config;

import cn.gsein.common.interceptor.CorsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMVC相关的自定义配置
 *
 * @author G.Seinfeld
 * @date 2018/12/27
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 增加拦截器
     *
     * @param registry 拦截器注册
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CorsInterceptor()).addPathPatterns("/**");
    }
}
