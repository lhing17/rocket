package cn.gsein.system.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

/**
 * Controller测试基类，用于统一模拟登录的session
 * @author G.Seinfeld
 * @date 2019/1/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BaseControllerTest {
    @Resource
    protected MockMvc mockMvc;

    /**
     * 空测试方法使得批量测试不报错
     */
    @Test
    public void testEmpty(){

    }

    MockHttpSession getLoginSession() throws Exception {
        return (MockHttpSession) mockMvc.perform(MockMvcRequestBuilders.post("/system/login?username=g_seinfeld" +
                "&password=123456")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andReturn().getRequest().getSession();
    }

}
