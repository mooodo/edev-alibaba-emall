package com.edev.emall.order.service.impl;

import com.edev.emall.order.entity.Order;
import com.edev.emall.order.entity.Payment;
import com.edev.emall.order.service.OrderService;
import com.edev.emall.order.service.PaymentService;
import com.edev.emall.order.service.impl.payment.PaymentAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("payment")
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private OrderService orderService;
    private Map<String, PaymentAdaptor> adaptors;
    private Map<String, PaymentAdaptor> getAdaptors() {
        if(adaptors == null)
            adaptors = applicationContext.getBeansOfType(PaymentAdaptor.class);
        return adaptors;
    }
    @Override
    public void payoff(Long customerId, Payment payment) {
        PaymentAdaptor adaptor = getAdaptors().get(payment.getMethod()+"Adaptor");
        adaptor.payoff(customerId, payment.getAmount());
    }

    @Override
    public void refund(Long customerId, Payment payment) {
        PaymentAdaptor adaptor = getAdaptors().get(payment.getMethod()+"Adaptor");
        adaptor.refund(customerId, payment.getAmount());
    }
}
