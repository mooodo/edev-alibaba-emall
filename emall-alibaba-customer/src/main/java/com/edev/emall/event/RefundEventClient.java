package com.edev.emall.event;

import com.edev.support.event.DomainEventInput;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface RefundEventClient extends DomainEventInput {
    @Override
    @Input("refund")
    SubscribableChannel input();
}
