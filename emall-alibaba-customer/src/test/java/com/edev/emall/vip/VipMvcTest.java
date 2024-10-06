package com.edev.emall.vip;

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
public class VipMvcTest {
    @Autowired
    private MockMvc mvc;
    /*
    1. 初始化
    2. 为客户注册会员
    3. 更新会员信息
    4. 从银卡会员升级成金卡会员
    5. 注销会员
     */
    @Test
    public void testRegisterAndModifyVip() throws Exception {
        String id = "10001";
        String json0 = JsonFile.read("json/vip/vip00.json");
        String excepted0 = JsonFile.read("json/vip/excepted00.json");
        // init test
        mvc.perform(get("/orm/vip/remove")
                .param("vipId", id)
        ).andExpect(status().isOk());

        // test register a silver vip
        mvc.perform(post("/orm/vip/register")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/vip/load")
                .param("vipId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test modify the silver vip
        String json1 = JsonFile.read("json/vip/vip01.json");
        String excepted1 = JsonFile.read("json/vip/excepted01.json");
        mvc.perform(post("/orm/vip/modify")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/vip/load")
                .param("vipId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test change the silver vip to a golden vip
        String json2 = JsonFile.read("json/vip/vip02.json");
        String excepted2 = JsonFile.read("json/vip/excepted02.json");
        mvc.perform(post("/orm/vip/modify")
                .content(json2).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/vip/load")
                .param("vipId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted2));

        // test remove the vip
        mvc.perform(get("/orm/vip/remove")
                .param("vipId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/vip/load")
                .param("vipId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
    /*
    1. 初始化
    2. 为客户注册会员
    3. 购买商品时为会员积分
    4. 会员用积分兑换商品
    5. 注销会员
     */
    @Test
    public void testAccumulateAndRedeemPoints() throws Exception {
        String id = "10015";
        String json0 = JsonFile.read("json/vip/vip03.json");
        String excepted0 = JsonFile.read("json/vip/excepted03.json");
        // init test
        mvc.perform(get("/orm/vip/remove")
                .param("vipId", id)
        ).andExpect(status().isOk());

        // test register a silver vip
        mvc.perform(post("/orm/vip/register")
                .content(json0).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id));
        mvc.perform(get("/orm/vip/load")
                .param("vipId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted0));

        // test accumulate points
        String excepted1 = JsonFile.read("json/vip/excepted04.json");
        mvc.perform(get("/orm/vip/accumulatePoints")
                .param("vipId", id).param("amount", "6000")
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/vip/load")
                .param("vipId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted1));

        // test redeem points
        String excepted2 = JsonFile.read("json/vip/excepted05.json");
        mvc.perform(get("/orm/vip/redeemPoints")
                .param("vipId", id).param("points", "3000")
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/vip/load")
                .param("vipId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted2));

        // test accumulate points again and upgrade vip level
        String excepted3 = JsonFile.read("json/vip/excepted06.json");
        mvc.perform(get("/orm/vip/accumulatePoints")
                .param("vipId", id).param("amount", "6000")
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/vip/load")
                .param("vipId", id)
        ).andExpect(status().isOk()).andExpect(content().json(excepted3));

        // test remove the vip
        mvc.perform(get("/orm/vip/remove")
                .param("vipId", id)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/vip/load")
                .param("vipId", id)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
