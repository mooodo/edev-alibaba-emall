package com.edev.emall.order.event;

import com.edev.support.event.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({PayoffEvent.class, ReturnGoodsEvent.class, PayWithAccountEvent.class, RefundEvent.class})
public class DomainEventConfig {
    @Autowired
    private PayoffEvent payoffEvent;
    @Bean
    public DomainEventPublisher payoffEvent() {
        return new DomainEventPublisher("payoff", payoffEvent);
    }
    @Autowired
    private ReturnGoodsEvent returnGoodsEvent;

    public DomainEventPublisher returnGoodsEvent() {
        return new DomainEventPublisher("returnGoods", returnGoodsEvent);
    }
    @Autowired
    private PayWithAccountEvent payWithAccountEvent;
    @Bean
    public DomainEventPublisher payWithAccountEvent() {
        return new DomainEventPublisher("payWithAccount", payWithAccountEvent);
    }
    @Autowired
    private RefundEvent refundEvent;
    @Bean
    public DomainEventPublisher refundEvent() {
        return new DomainEventPublisher("refund", refundEvent);
    }
}
