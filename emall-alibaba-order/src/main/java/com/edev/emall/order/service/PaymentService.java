package com.edev.emall.order.service;

import com.edev.emall.order.entity.Payment;

public interface PaymentService {
    void payoff(Long id, String paymentMethod);
    void refund(Long id);
    void remove(Long id);
    Payment load(Long id);
}
