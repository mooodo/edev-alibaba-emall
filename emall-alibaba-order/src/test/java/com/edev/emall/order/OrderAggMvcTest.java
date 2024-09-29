package com.edev.emall.order;

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
public class OrderAggMvcTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void testCancelOrder() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/order/order02.json");
        String excepted0 = JsonFile.read("json/order/excepted02.json");
        // init test
        mvc.perform(get("/orm/order/remove")
                .param("orderId", id)
        ).andExpect(status().isOk());

        //place an order
        mvc.perform(post("/orm/orderAgg/placeOrder")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/order/load")
                .param("orderId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        //cancel the order
        mvc.perform(get("/orm/orderAgg/cancelOrder")
                .param("orderId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/order/load")
                .param("orderId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
    @Test
    public void testPayoffOrderAndReturnGoods() throws Exception {
        String id = "1";
        String json0 = JsonFile.read("json/order/order02.json");
        String excepted0 = JsonFile.read("json/order/excepted02.json");
        // init test
        mvc.perform(get("/orm/order/remove")
                .param("orderId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/payment/remove")
                .param("id", id)
        ).andExpect(status().isOk());

        // test place an order
        mvc.perform(post("/orm/orderAgg/placeOrder")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/order/load")
                .param("orderId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test payoff for the order
        String excepted1 = JsonFile.read("json/order/excepted03.json");
        mvc.perform(get("/orm/orderAgg/payoff")
                .param("orderId", id).param("paymentMethod", "account")
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/order/load")
                .param("orderId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test return goods from the order
        String excepted2 = JsonFile.read("json/order/excepted04.json");
        mvc.perform(get("/orm/orderAgg/returnGoods")
                .param("orderId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/order/load")
                .param("orderId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted2));

        // clear all data
        mvc.perform(get("/orm/order/remove")
                .param("orderId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/payment/remove")
                .param("id", id)
        ).andExpect(status().isOk());
    }
}
