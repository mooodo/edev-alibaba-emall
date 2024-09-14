package com.edev.emall.inventory.event.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderItem extends Entity<Long> {
    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double price;
    private Double amount;
}
