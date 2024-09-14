package com.edev.emall.order.event;

import com.edev.support.event.DomainEventOutput;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RefundEvent extends DomainEventOutput {
    @Override
    @Output("refund")
    MessageChannel output();
}
