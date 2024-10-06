package com.edev.emall.customer;

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
public class AccountMvcTest {
    @Autowired
    private MockMvc mvc;
    /*
    1. 初始化
    2. 为客户创建账户并首次充值
    3. 再次充值
    4. 为订单进行支付
    5. 订单退货后的退款
    6. 注销账户
     */
    @Test
    public void testTopUpAndPayoff() throws Exception {
        String id = "10010";
        // init test
        mvc.perform(get("/orm/account/remove")
                .param("id", id)
        ).andExpect(status().isOk());

        // test top up first
        String excepted0 = JsonFile.read("json/account/excepted0.json");
        mvc.perform(get("/orm/account/topUp")
                .param("id", id).param("amount", "20000")
        ).andExpect(status().isOk()).andExpect(content().string("20000.0"));
        mvc.perform(get("/orm/account/get")
                .param("id", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test top up again
        String excepted1 = JsonFile.read("json/account/excepted1.json");
        mvc.perform(get("/orm/account/topUp")
                .param("id", id).param("amount", "2000")
        ).andExpect(status().isOk()).andExpect(content().string("22000.0"));
        mvc.perform(get("/orm/account/get")
                .param("id", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test payoff
        String excepted2 = JsonFile.read("json/account/excepted2.json");
        mvc.perform(get("/orm/account/payoff")
                .param("id", id).param("amount", "3000")
        ).andExpect(status().isOk()).andExpect(content().string("19000.0"));
        mvc.perform(get("/orm/account/get")
                .param("id", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted2));

        // test refund
        mvc.perform(get("/orm/account/refund")
                .param("id", id).param("amount", "3000")
        ).andExpect(status().isOk()).andExpect(content().string("22000.0"));
        mvc.perform(get("/orm/account/get")
                .param("id", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test remove account
        mvc.perform(get("/orm/account/remove")
                .param("id", id)
        ).andExpect(status().isOk());
    }
}
