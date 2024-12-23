package com.edev.emall.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDiscount extends Discount {
    private Long productId;
}
