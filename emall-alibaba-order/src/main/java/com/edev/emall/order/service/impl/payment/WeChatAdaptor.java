package com.edev.emall.order.service.impl.payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("weChatAdaptor")
@Slf4j
public class WeChatAdaptor implements PaymentAdaptor {
    @Override
    public void payoff(Long customerId, Double amount) {
        log.info(String.format("payoff using the customer's wechat: [customerId: %s, amount: %f]", customerId, amount));
        //TODO connect to wechat
    }
    @Override
    public void refund(Long customerId, Double amount) {
        log.info(String.format("refund to the customer's wechat: [customerId: %s, amount: %f]", customerId, amount));
        //TODO connect to wechat
    }
}
