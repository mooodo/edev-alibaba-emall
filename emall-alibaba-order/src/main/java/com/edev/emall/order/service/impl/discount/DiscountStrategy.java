package com.edev.emall.order.service.impl.discount;

import com.edev.emall.order.entity.Order;

public interface DiscountStrategy {
    void doDiscount(Order order);
}
