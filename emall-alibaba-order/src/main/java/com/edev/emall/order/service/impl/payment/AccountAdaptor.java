package com.edev.emall.order.service.impl.payment;

import com.edev.support.event.DomainEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component("accountAdaptor")
@Slf4j
public class AccountAdaptor implements PaymentAdaptor {
    @Autowired @Qualifier("payWithAccountEvent")
    private DomainEventPublisher payWithAccountEvent;
    @Autowired @Qualifier("refundEvent")
    private DomainEventPublisher refundEvent;
    @Override
    @Transactional
    public void payoff(Long customerId, Double amount) {
        Map<String, Object> map = new HashMap<>();
        map.put("customerId", customerId);
        map.put("amount", amount);
        payWithAccountEvent.publish("accountAdaptor", map);
    }
    @Override
    @Transactional
    public void refund(Long customerId, Double amount) {
        Map<String, Object> map = new HashMap<>();
        map.put("customerId", customerId);
        map.put("amount", amount);
        refundEvent.publish("accountAdaptor", map);
    }
}
