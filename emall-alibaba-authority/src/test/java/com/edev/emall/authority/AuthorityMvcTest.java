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
public class AuthorityMvcTest {
    @Autowired
    private MockMvc mvc;
    /*
    1.仅仅创建一个权限
    2.为权限分配用户
    3.为权限分配角色
    4.删除权限
     */
    @Test
    public void testCreateAndModifyAuthority() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/authority/authority00.json");
        String excepted0 = JsonFile.read("json/authority/excepted00.json");
        // init test
        mvc.perform(get("/orm/authority/remove")
                .param("authorityId", id)
        ).andExpect(status().isOk());

        // test create authority
        mvc.perform(post("/orm/authority/create")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/authority/load")
                .param("authorityId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test add a user for the authority
        String json1 = JsonFile.read("json/authority/authority01.json");
        String excepted1 = JsonFile.read("json/authority/excepted01.json");
        mvc.perform(post("/orm/authority/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/authority/load")
                .param("authorityId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test add a role for the authority
        String json2 = JsonFile.read("json/authority/authority02.json");
        String excepted2 = JsonFile.read("json/authority/excepted02.json");
        mvc.perform(post("/orm/authority/modify")
                .content(json2).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/authority/load")
                .param("authorityId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted2));

        // test remove the authority
        mvc.perform(get("/orm/authority/remove")
                .param("authorityId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/authority/load")
                .param("authorityId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
    /*
    1.创建权限并为其分配用户
    2.修改权限分配的用户
    3.删除权限
     */
    @Test
    public void testCreateAndModifyWithUser() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/authority/authority10.json");
        String excepted0 = JsonFile.read("json/authority/excepted10.json");
        // init test
        mvc.perform(get("/orm/authority/remove")
                .param("authorityId", id)
        ).andExpect(status().isOk());

        // test create authority and add a user
        mvc.perform(post("/orm/authority/create")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/authority/load")
                .param("authorityId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test modify authority with user
        String json1 = JsonFile.read("json/authority/authority11.json");
        String excepted1 = JsonFile.read("json/authority/excepted11.json");
        mvc.perform(post("/orm/authority/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/authority/load")
                .param("authorityId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test remove the authority
        mvc.perform(get("/orm/authority/remove")
                .param("authorityId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/authority/load")
                .param("authorityId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
    /*
    1.创建权限并为其分配角色
    2.修改权限分配的角色
    3.删除权限
     */
    @Test
    public void testCreateAndModifyWithRole() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/authority/authority20.json");
        String excepted0 = JsonFile.read("json/authority/excepted20.json");
        // init test
        mvc.perform(get("/orm/authority/remove")
                .param("authorityId", id)
        ).andExpect(status().isOk());

        // test create authority and add a user
        mvc.perform(post("/orm/authority/create")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/authority/load")
                .param("authorityId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test modify authority with user
        String json1 = JsonFile.read("json/authority/authority21.json");
        String excepted1 = JsonFile.read("json/authority/excepted21.json");
        mvc.perform(post("/orm/authority/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/authority/load")
                .param("authorityId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test remove the authority
        mvc.perform(get("/orm/authority/remove")
                .param("authorityId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/authority/load")
                .param("authorityId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
