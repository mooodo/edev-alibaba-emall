package com.edev.emall.order.service.impl;

import com.edev.emall.order.entity.Order;
import com.edev.emall.order.service.OrderAggService;
import com.edev.emall.order.service.OrderService;
import com.edev.emall.order.service.PaymentService;
import com.edev.support.event.DomainEventPublisher;
import com.edev.support.exception.ValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderAgg")
@Slf4j
public class OrderAggServiceImpl implements OrderAggService {
    @Autowired @Qualifier("payoffEvent")
    private DomainEventPublisher payoffEvent;
    @Autowired @Qualifier("returnGoodsEvent")
    private DomainEventPublisher returnGoodsEvent;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentService paymentService;
    @Override
    public void placeOrder(Order order) {
        log.debug("create an order");
        orderService.create(order);
    }

    @Override
    public void cancelOrder(Long orderId) {
        Order order = orderService.load(orderId);
        if(order.getPayment()!=null && !"ready".equals(order.getPayment().getStatus()))
            throw new ValidException("The order has payoff, so cannot cancel!");
        log.debug("remove the order");
        orderService.remove(orderId);
    }

    @Override
    @Transactional
    public void payoff(Long orderId, String paymentMethod) {
        Order order = orderService.load(orderId);
        if(order==null) throw new ValidException("The order not exists[orderId:%s]",orderId);

        log.debug("change the order's status to payoff");
        if(order.getPayment()==null) order.readyForPay();
        if(!"ready".equals(order.getPayment().getStatus()))
            throw new ValidException("The order[orderId:%s] has payoff and cannot payoff twice!",orderId);
        order.payoff(paymentMethod);
        orderService.modify(order);

        log.debug("payoff the order");
        paymentService.payoff(order.getCustomerId(), order.getPayment());

        payoffEvent.publish("orderAggService", order);
    }

    @Override
    @Transactional
    public void returnGoods(Long orderId) {
        Order order = orderService.load(orderId);
        if(order==null) throw new ValidException("The order not exists[orderId:%s]",orderId);

        log.debug("change the order's status to return goods");
        if(order.getPayment()==null||!"payoff".equals(order.getPayment().getStatus()))
            throw new ValidException("The order[orderId:%s] cannot return goods!",orderId);
        order.setStatus("return goods");
        order.getPayment().setStatus("refund");
        orderService.modify(order);

        log.debug("refund for the order");
        paymentService.refund(order.getCustomerId(), order.getPayment());

        returnGoodsEvent.publish("orderAggService", order);
    }
}
