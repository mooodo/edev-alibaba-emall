package com.edev.emall.supplier;

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
public class StaffMvcTest {
    @Autowired
    private MockMvc mvc;
    /*
    1. 初始化
    2. 为某个供应商添加员工
    3. 更新员工信息
    4. 删除员工信息
     */
    @Test
    public void testCreateAndModifyStaff() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/staff/staff00.json");
        String excepted0 = JsonFile.read("json/staff/excepted00.json");
        // init test
        mvc.perform(get("/orm/staff/remove")
                .param("staffId", id)
        ).andExpect(status().isOk());

        // test create staff
        mvc.perform(post("/orm/staff/create")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/staff/load")
                .param("staffId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test modify staff
        String json1 = JsonFile.read("json/staff/staff01.json");
        String excepted1 = JsonFile.read("json/staff/excepted01.json");
        mvc.perform(post("/orm/staff/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/staff/load")
                .param("staffId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test remove
        mvc.perform(get("/orm/staff/remove")
                .param("staffId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/staff/load")
                .param("staffId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
