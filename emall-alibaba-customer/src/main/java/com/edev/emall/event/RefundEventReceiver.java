package com.edev.emall.event;

import com.edev.emall.customer.service.AccountService;
import com.edev.emall.event.entity.Order;
import com.edev.support.event.DomainEventObject;
import com.edev.support.event.DomainEventReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@EnableBinding(RefundEventClient.class)
public class RefundEventReceiver implements DomainEventReceiver {
    @Autowired
    private AccountService accountService;
    @Override
    @StreamListener("refund")
    public void apply(DomainEventObject event) {
        log.info("refund to the customer's account");
        Map<String, Object> map = event.convertToMap();
        Long customerId = Long.parseLong(map.get("customerId").toString());
        Double amount = Double.parseDouble(map.get("amount").toString());
        accountService.refund(customerId, amount);
    }
}
