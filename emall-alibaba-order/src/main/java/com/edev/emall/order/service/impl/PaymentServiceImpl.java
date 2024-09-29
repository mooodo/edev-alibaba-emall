package com.edev.emall.order.service.impl;

import com.edev.emall.order.entity.Order;
import com.edev.emall.order.entity.Payment;
import com.edev.emall.order.service.OrderService;
import com.edev.emall.order.service.PaymentService;
import com.edev.emall.order.service.impl.payment.PaymentAdaptor;
import com.edev.support.dao.BasicDao;
import com.edev.support.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Map;

import static com.edev.emall.utils.ValidUtils.isNull;
public class PaymentServiceImpl implements PaymentService {
    private final BasicDao dao;
    public PaymentServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
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
    public void payoff(Long id, String paymentMethod) {
        Order order = orderService.load(id);
        isNull(order, "The order which pay for is not exists");
        Payment payment = new Payment();
        payment.setId(order.getId());
        payment.setAmount(order.getAmount());
        payment.setMethod(paymentMethod);
        payment.setStatus("payoff");
        payment.setPaymentTime(DateUtils.getNow());
        dao.insert(payment);

        PaymentAdaptor adaptor = getAdaptors().get(payment.getMethod()+"Adaptor");
        adaptor.payoff(order.getCustomerId(), payment.getAmount());
    }

    @Override
    public void refund(Long id) {
        Order order = orderService.load(id);
        isNull(order, "The order which refund for is not exists");
        Payment payment = order.getPayment();
        payment.setStatus("refund");
        dao.update(payment);

        PaymentAdaptor adaptor = getAdaptors().get(payment.getMethod()+"Adaptor");
        adaptor.refund(order.getCustomerId(), payment.getAmount());
    }

    @Override
    public void remove(Long id) {
        dao.delete(id, Payment.class);
    }

    @Override
    public Payment load(Long id) {
        return dao.load(id, Payment.class);
    }
}
