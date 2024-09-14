package com.edev.emall.event;

import com.edev.emall.customer.service.AccountService;
import com.edev.emall.event.entity.Order;
import com.edev.emall.vip.service.VipService;
import com.edev.support.event.DomainEventObject;
import com.edev.support.event.DomainEventReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(PayoffEventClient.class)
@Slf4j
public class PayoffEventReceiver implements DomainEventReceiver {
    @Autowired
    private AccountService accountService;
    @Autowired
    private VipService vipService;
    @Override
    public void apply(DomainEventObject event) {
        Order order = event.convertToEntity(Order.class);
        log.debug("accumulate points if is vip");
        vipService.accumulatePoints(order.getCustomerId(), order.getAmount());
    }
}
