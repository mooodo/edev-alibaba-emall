package com.edev.emall.inventory.event;

import com.edev.emall.inventory.event.entity.Order;
import com.edev.emall.inventory.service.InventoryService;
import com.edev.support.event.DomainEventObject;
import com.edev.support.event.DomainEventReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(ReturnGoodsEventClient.class)
public class ReturnGoodsEventReceiver implements DomainEventReceiver {
    @Autowired
    private InventoryService inventoryService;
    @Override
    @StreamListener("returnGoods")
    public void apply(DomainEventObject event) {
        Order order = event.convertToEntity(Order.class);
        log.debug("stock in for each of the order items");
        order.getOrderItems().forEach(orderItem -> inventoryService.stockIn(orderItem.getProductId(), orderItem.getQuantity()));
    }
}
