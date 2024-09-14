package com.edev.emall.order.service.impl.payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("alipayAdaptor")
@Slf4j
public class AlipayAdaptor implements PaymentAdaptor {
    @Override
    public void payoff(Long customerId, Double amount) {
        log.info(String.format("payoff using the customer's alipay: [customerId: %d, amount: %f]", customerId, amount));
        //TODO connect to alipay
    }
    @Override
    public void refund(Long customerId, Double amount) {
        log.info(String.format("refund to the customer's alipay: [customerId: %d, amount: %f]", customerId, amount));
        //TODO connect to alipay
    }
}
