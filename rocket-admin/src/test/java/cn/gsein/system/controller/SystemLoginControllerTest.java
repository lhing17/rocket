package cn.gsein.system.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * 登录相关的控制器测试类
 *
 * @author G.Seinfeld
 * @date 2018/12/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SystemLoginControllerTest {

    @Resource
    private MockMvc mockMvc;

    /**
     * 测试不需要生成图形验证码的场景
     */
    @Test
    public void generateCaptcha() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/generateCaptcha"))
                .andDo(print());
    }

    /**
     * 测试登录失败的场景——用户不存在
     */
    @Test
    public void loginNoAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/system/login?username=123&password=456")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("5002"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("用户名或密码不正确"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").isEmpty());

    }

    /**
     * 测试登录失败的场景——密码错误
     */
    @Test
    public void loginWrongPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/system/login?username=g_seinfeld&password=456")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("5001"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("用户名或密码不正确"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").isEmpty());

    }

    /**
     * 测试登录成功的场景
     */
    @Test
    public void loginSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/system/login?username=g_seinfeld&password=123456")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("请求成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").isEmpty());

    }


}