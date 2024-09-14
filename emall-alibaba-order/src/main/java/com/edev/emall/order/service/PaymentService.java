package com.edev.emall.order.service;

import com.edev.emall.order.entity.Payment;

public interface PaymentService {
    void payoff(Long customerId, Payment payment);
    void refund(Long customerId, Payment payment);
}
