package cn.gsein.system.controller;

import cn.gsein.system.entity.JsonResult;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 系统用户控制器类的测试类
 *
 * @author G.Seinfeld
 * @date 2018/12/26
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class SystemUserControllerTest {

    @Resource
    private TestRestTemplate template;

    @Resource
    private MockMvc mockMvc;


    /**
     * 测试用户名为空的场景
     */
    @Test
    public void saveUserUserNameEmpty() {
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>(16);
        HttpEntity<MultiValueMap<String, Object>> httpEntity =
                new HttpEntity<>(paramMap, headers);
        ResponseEntity<JsonResult> response = template.postForEntity("/system/user/save", httpEntity, JsonResult.class);
        JsonResult result = response.getBody();
        Assertions.assertThat(result).hasFieldOrPropertyWithValue("code", "5005");
        Assertions.assertThat(result).hasFieldOrPropertyWithValue("message", "用户名或密码为空");
    }

    /**
     * 测试密码为空的场景
     */
    @Test
    public void saveUserPasswordEmpty() {
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>(16);
        HttpEntity<MultiValueMap<String, Object>> httpEntity =
                new HttpEntity<>(paramMap, headers);
        paramMap.add("username", "g_seinfeld");
        ResponseEntity<JsonResult> response = template.postForEntity("/system/user/save", httpEntity, JsonResult.class);
        JsonResult result = response.getBody();
        Assertions.assertThat(result).hasFieldOrPropertyWithValue("code", "5005");
        Assertions.assertThat(result).hasFieldOrPropertyWithValue("message", "用户名或密码为空");
    }

    /**
     * 测试用户名已存在的场景
     */
    @Test
    public void saveUserUsernameExists() {
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>(16);
        paramMap.add("username", "g_seinfeld");
        paramMap.add("password", "123456");
        HttpEntity<MultiValueMap<String, Object>> httpEntity =
                new HttpEntity<>(paramMap, headers);
        ResponseEntity<JsonResult> response = template.postForEntity("/system/user/save", httpEntity, JsonResult.class);
        JsonResult result = response.getBody();
        Assertions.assertThat(result).hasFieldOrPropertyWithValue("code", "5004");
        Assertions.assertThat(result).hasFieldOrPropertyWithValue("message", "用户名已存在");
    }

    /**
     * 测试保存用户成功的场景
     */
    @Test
    @Transactional
    public void saveUserSuccess() throws Exception {
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>(16);
        paramMap.add("username", "no_seinfeld");
        paramMap.add("password", "123456");
        paramMap.add("mobile", "13253392599");
        paramMap.add("deptId", "1");
        paramMap.add("status", "0");
        mockMvc.perform(MockMvcRequestBuilders.post("/system/user/save")
                .session((MockHttpSession) getloginSession())
                .params(paramMap)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("请求成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").isEmpty());
    }

    /**
     * 测试修改用户密码成功的场景
     */
    @Test
    @Transactional
    public void changePasswordSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/system/user/changePassword?oldPassword=123456&newPassword=654321")
                .session((MockHttpSession) getloginSession())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("请求成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").isEmpty());
    }

    @Test
    public void userList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/system/user/list?current=1&pageSize=2")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("请求成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").hasJsonPath());

    }

    private HttpSession getloginSession() throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post("/system/login?username=g_seinfeld&password=123456")
                .accept(MediaType.APPLICATION_JSON_UTF8)).andReturn().getRequest().getSession();
    }

}