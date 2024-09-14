package com.edev.emall.authority;

import com.edev.support.utils.JsonFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserMvcTest {
    @Autowired
    private MockMvc mvc;
    /*
    1.初始化
    2.注册用户
    3.修改密码，分配角色
    4.清除角色，添加功能
    5.删除用户
     */
    @Test
    public void testRegisterAndModifyUser() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/user/user00.json");
        String excepted0 = JsonFile.read("json/user/excepted00.json");
        // init test
        mvc.perform(get("/orm/user/remove")
                .param("userId", id)
        ).andExpect(status().isOk());

        // test register
        mvc.perform(post("/orm/user/register")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/user/load")
                .param("userId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test change password and add a role
        String json1 = JsonFile.read("json/user/user01.json");
        String excepted1 = JsonFile.read("json/user/excepted01.json");
        mvc.perform(post("/orm/user/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/user/load")
                .param("userId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test remove role and add some authorities
        String json2 = JsonFile.read("json/user/user02.json");
        String excepted2 = JsonFile.read("json/user/excepted02.json");
        mvc.perform(post("/orm/user/modify")
                .content(json2).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/user/load")
                .param("userId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted2));

        // test remove
        mvc.perform(get("/orm/user/remove")
                .param("userId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/user/load")
                .param("userId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
    /*
    1.注册用户，并分配角色
    2.修改用户，调整其角色分配
    3.删除用户
     */
    @Test
    public void testRegisterAndModifyWithRole() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/user/user10.json");
        String excepted0 = JsonFile.read("json/user/excepted10.json");
        // init test
        mvc.perform(get("/orm/user/remove")
                .param("userId", id)
        ).andExpect(status().isOk());

        // test register
        mvc.perform(post("/orm/user/register")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/user/load")
                .param("userId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test modify
        String json1 = JsonFile.read("json/user/user11.json");
        String excepted1 = JsonFile.read("json/user/excepted11.json");
        mvc.perform(post("/orm/user/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/user/load")
                .param("userId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test remove
        mvc.perform(get("/orm/user/remove")
                .param("userId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/user/load")
                .param("userId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
    /*
    1.注册用户并直接授权
    2.修改用户及其权限
    3.删除用户
     */
    @Test
    public void testRegisterAndModifyWithAuthority() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/user/user20.json");
        String excepted0 = JsonFile.read("json/user/excepted20.json");
        // init test
        mvc.perform(get("/orm/user/remove")
                .param("userId", id)
        ).andExpect(status().isOk());

        // test register
        mvc.perform(post("/orm/user/register")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/user/load")
                .param("userId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test modify
        String json1 = JsonFile.read("json/user/user21.json");
        String excepted1 = JsonFile.read("json/user/excepted21.json");
        mvc.perform(post("/orm/user/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/user/load")
                .param("userId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test remove
        mvc.perform(get("/orm/user/remove")
                .param("userId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/user/load")
                .param("userId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
