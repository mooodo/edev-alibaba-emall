package com.edev.emall.customer;

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
public class CustomerMvcTest {
    @Autowired
    private MockMvc mvc;
    /*
    1.仅仅创建一个客户
    2.为客户添加地址
    3.删除客户
     */
    @Test
    public void testRegisterAndModifyCustomer() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/customer/customer00.json");
        String excepted0 = JsonFile.read("json/customer/excepted00.json");
        // init test
        mvc.perform(get("/orm/customer/remove")
                .param("customerId", id)
        ).andExpect(status().isOk());

        // test register customer
        mvc.perform(post("/orm/customer/register")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/customer/load")
                .param("customerId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test add an address for the customer
        String json1 = JsonFile.read("json/customer/customer01.json");
        String excepted1 = JsonFile.read("json/customer/excepted01.json");
        mvc.perform(post("/orm/customer/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/customer/load")
                .param("customerId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test remove the customer
        mvc.perform(get("/orm/customer/remove")
                .param("customerId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/customer/load")
                .param("customerId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
    /*
    1.添加新的客户及其地址
    2.更新客户信息及其地址
    3.删除客户
     */
    @Test
    public void testRegisterAndModifyWithAddress() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/customer/customer10.json");
        String excepted0 = JsonFile.read("json/customer/excepted10.json");
        // init test
        mvc.perform(get("/orm/customer/remove")
                .param("customerId", id)
        ).andExpect(status().isOk());

        // test register customer
        mvc.perform(post("/orm/customer/register")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/customer/load")
                .param("customerId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test add an address for the customer
        String json1 = JsonFile.read("json/customer/customer11.json");
        String excepted1 = JsonFile.read("json/customer/excepted11.json");
        mvc.perform(post("/orm/customer/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/customer/load")
                .param("customerId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test remove the customer
        mvc.perform(get("/orm/customer/remove")
                .param("customerId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/customer/load")
                .param("customerId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
