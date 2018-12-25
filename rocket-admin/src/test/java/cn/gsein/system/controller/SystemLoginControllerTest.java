package cn.gsein.system.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 * @author G.Seinfeld
 * @date 2018/12/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SystemLoginControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void login() throws Exception {
        System.out.println(mockMvc);
        mockMvc.perform(MockMvcRequestBuilders.post("/system/login?username=123&password=456")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("5002"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("用户名或密码不正确"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").isEmpty())
        ;

    }


}