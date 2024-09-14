package com.edev.emall.order.service.impl.payment;

public interface PaymentAdaptor {
    void payoff(Long customerId, Double amount);
    void refund(Long customerId, Double amount);
}
