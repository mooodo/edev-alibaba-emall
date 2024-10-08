package com.edev.emall.order.web;

import com.edev.emall.order.entity.Order;
import com.edev.emall.order.service.OrderAggService;
import com.edev.emall.order.service.OrderService;
import com.edev.support.entity.ResultSet;
import com.edev.support.query.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderAggService orderAggService;
    @PostMapping("placeOrder")
    public void placeOrder(@RequestBody Order order) {
        orderAggService.placeOrder(order);
    }
    @GetMapping("cancelOrder")
    public void cancelOrder(Long orderId) {
        orderAggService.cancelOrder(orderId);
    }
    @PostMapping("payoff")
    public void payoff(Long orderId, String paymentMethod) {
        orderAggService.payoff(orderId, paymentMethod);
    }
    @GetMapping("returnGoods")
    public void returnGoods(Long orderId) {
        orderAggService.returnGoods(orderId);
    }
    @Autowired
    protected OrderService orderService;
    @PostMapping("load")
    public Order load(Long orderId) {
        return orderService.load(orderId);
    }
    @Autowired @Qualifier("orderQry")
    private QueryService queryService;
    @PostMapping("query")
    public ResultSet query(@RequestBody Map<String, Object> params) {
        return queryService.query(params);
    }
}
