package com.edev.emall.inventory;

import com.edev.support.utils.JsonFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InventoryMvcTest {
    @Autowired
    private MockMvc mvc;
    /*
    1. 初始化
    2. 为商品首次入库，入库前先创建库存
    3. 再次入库
    4. 出库/库存扣减
    5. 删除库存
     */
    @Test
    public void testStockInAndStockOut() throws Exception {
        String id = "1";
        mvc.perform(get("/orm/inventory/remove")
                .param("productId", id)
        ).andExpect(status().isOk());

        String excepted0 = JsonFile.read("json/inventory/excepted00.json");
        mvc.perform(get("/orm/inventory/stockIn")
                .param("productId", id).param("quantity", "1000")
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/inventory/check")
                .param("productId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        String excepted1 = JsonFile.read("json/inventory/excepted01.json");
        mvc.perform(get("/orm/inventory/stockIn")
                .param("productId", id).param("quantity", "500")
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/inventory/check")
                .param("productId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        mvc.perform(get("/orm/inventory/stockOut")
                .param("productId", id).param("quantity", "500")
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/inventory/check")
                .param("productId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        mvc.perform(get("/orm/inventory/remove")
                .param("productId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/inventory/check")
                .param("productId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
