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
public class RoleMvcTest {
    @Autowired
    private MockMvc mvc;
    /*
    1.仅仅创建一个角色
    2.为角色分配权限
    3.为角色分配用户
    4.删除角色
     */
    @Test
    public void testCreateAndModifyRole() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/role/role00.json");
        String excepted0 = JsonFile.read("json/role/excepted00.json");
        // init test
        mvc.perform(get("/orm/role/remove")
                .param("roleId", id)
        ).andExpect(status().isOk());

        // test create role
        mvc.perform(post("/orm/role/create")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/role/load")
                .param("roleId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test add an authority for the role
        String json1 = JsonFile.read("json/role/role01.json");
        String excepted1 = JsonFile.read("json/role/excepted01.json");
        mvc.perform(post("/orm/role/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/role/load")
                .param("roleId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test add a user for the role
        String json2 = JsonFile.read("json/role/role02.json");
        String excepted2 = JsonFile.read("json/role/excepted02.json");
        mvc.perform(post("/orm/role/modify")
                .content(json2).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/role/load")
                .param("roleId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted2));

        // test remove the role
        mvc.perform(get("/orm/role/remove")
                .param("roleId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/role/load")
                .param("roleId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
    /*
    1.创建角色的同时，为其分配权限
    2.更新角色分配的权限
    3.删除角色
     */
    @Test
    public void testCreateAndModifyWithAuthority() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/role/role10.json");
        String excepted0 = JsonFile.read("json/role/excepted10.json");
        // init test
        mvc.perform(get("/orm/role/remove")
                .param("roleId", id)
        ).andExpect(status().isOk());

        // test create role
        mvc.perform(post("/orm/role/create")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/role/load")
                .param("roleId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test add an authority for the role
        String json1 = JsonFile.read("json/role/role11.json");
        String excepted1 = JsonFile.read("json/role/excepted11.json");
        mvc.perform(post("/orm/role/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/role/load")
                .param("roleId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test remove the role
        mvc.perform(get("/orm/role/remove")
                .param("roleId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/role/load")
                .param("roleId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
    /*
    1.创建角色的同时，为其分配用户
    2.更新角色分配的用户
    3.删除角色
     */
    @Test
    public void testCreateAndModifyWithUser() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/role/role20.json");
        String excepted0 = JsonFile.read("json/role/excepted20.json");
        // init test
        mvc.perform(get("/orm/role/remove")
                .param("roleId", id)
        ).andExpect(status().isOk());

        // test create role
        mvc.perform(post("/orm/role/create")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/role/load")
                .param("roleId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test add an authority for the role
        String json1 = JsonFile.read("json/role/role21.json");
        String excepted1 = JsonFile.read("json/role/excepted21.json");
        mvc.perform(post("/orm/role/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/role/load")
                .param("roleId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test remove the role
        mvc.perform(get("/orm/role/remove")
                .param("roleId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/role/load")
                .param("roleId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
