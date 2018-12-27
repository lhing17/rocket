package cn.gsein;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 后端项目的启动类
 * @author G.Seinfeld
 * @date 2018/12/24
 */
@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = {"cn.gsein.*.mapper"})
public class AdminApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminApplication.class);
    }
}
