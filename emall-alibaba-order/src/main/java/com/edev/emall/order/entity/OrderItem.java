package com.edev.emall.order.entity;

import com.edev.emall.product.entity.Product;
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
    private Product product;
}
