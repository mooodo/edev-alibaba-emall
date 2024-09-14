package com.edev.emall.inventory.event;

import com.edev.support.event.DomainEventInput;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PayoffEventClient extends DomainEventInput {
    @Override
    @Input("payoff")
    SubscribableChannel input();
}
