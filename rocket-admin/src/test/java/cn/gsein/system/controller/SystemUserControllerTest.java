package cn.gsein.system.controller;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * 系统用户控制器类的测试类
 *
 * @author G.Seinfeld
 * @date 2018/12/26
 */
public class SystemUserControllerTest extends BaseControllerTest {


    /**
     * 测试用户名为空的场景
     */
    @Test
    public void saveUserUserNameEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/system/user/save")
                .session(getLoginSession())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("5005"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("用户名或密码为空"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").isEmpty());

    }

    /**
     * 测试用户名已存在的场景
     */
    @Test
    public void saveUserUsernameExists() throws Exception {
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>(16);
        paramMap.add("username", "g_seinfeld");
        paramMap.add("password", "123456");
        mockMvc.perform(MockMvcRequestBuilders.post("/system/user/save")
                .session(getLoginSession())
                .params(paramMap)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("5004"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("用户名已存在"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").isEmpty());
        HttpHeaders headers = new HttpHeaders();
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
                .session(getLoginSession())
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
        mockMvc.perform(MockMvcRequestBuilders.put("/system/user/changePassword?oldPassword=123456&newPassword=654321")
                .session(getLoginSession())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("请求成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").isEmpty());
    }

    /**
     * 测试重置用户密码成功的场景
     */
    @Test
    @Transactional
    public void resetPasswordSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/system/user/resetPassword?userId=1&newPassword=654321")
                .session(getLoginSession())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("请求成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").isEmpty());
    }

    @Test
    @Transactional
    public void updateUserSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/system/user/update?id=1&username=g_seinfeld&mobile=13253392599")
                .session(getLoginSession())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("请求成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").isEmpty());
    }

    @Test
    public void userList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/system/user/list?current=1&pageSize=2")
                .session(getLoginSession())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("code").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("请求成功"))
                .andExpect(MockMvcResultMatchers.jsonPath("data").hasJsonPath());

    }

}