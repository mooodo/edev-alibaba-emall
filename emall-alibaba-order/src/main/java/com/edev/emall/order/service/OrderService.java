package com.edev.emall.order.service;

import com.edev.emall.order.entity.Order;

public interface OrderService {
    Long create(Order order);
    void modify(Order order);
    void remove(Long orderId);
    Order load(Long orderId);
}
