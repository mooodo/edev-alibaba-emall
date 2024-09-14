package com.edev.emall.order.service;

import com.edev.emall.order.entity.Order;

public interface OrderAggService {
    void placeOrder(Order order);
    void cancelOrder(Long orderId);
    void payoff(Long orderId, String paymentMethod);
    void returnGoods(Long orderId);
}
