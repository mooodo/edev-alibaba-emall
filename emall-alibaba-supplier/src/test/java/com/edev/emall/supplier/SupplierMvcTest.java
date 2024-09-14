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
public class SupplierMvcTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void testCreateAndModifySupplier() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/supplier/supplier00.json");
        String excepted0 = JsonFile.read("json/supplier/excepted00.json");
        // init test
        mvc.perform(get("/orm/supplier/remove")
                .param("supplierId", id)
        ).andExpect(status().isOk());

        // test create supplier
        mvc.perform(post("/orm/supplier/create")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/supplier/load")
                .param("supplierId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test modify supplier
        String json1 = JsonFile.read("json/supplier/supplier01.json");
        String excepted1 = JsonFile.read("json/supplier/excepted01.json");
        mvc.perform(post("/orm/supplier/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/supplier/load")
                .param("supplierId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test remove
        mvc.perform(get("/orm/supplier/remove")
                .param("supplierId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/supplier/load")
                .param("supplierId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
