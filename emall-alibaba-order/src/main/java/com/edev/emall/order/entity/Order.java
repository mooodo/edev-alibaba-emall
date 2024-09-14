package com.edev.emall.order.entity;

import com.edev.support.entity.Entity;
import com.edev.support.utils.DateUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Order extends Entity<Long> {
    private Long id;
    private Long customerId;
    private Long addressId;
    private String status;
    private Double amount;
    private Date orderTime;
    private Date modifyTime;
    private Customer customer;
    private Address address;
    private Payment payment;
    private List<OrderItem> orderItems;
    public void calculateAmountForEachItem() {
        this.getOrderItems().forEach(orderItem -> {
            double amount = orderItem.getPrice() * orderItem.getQuantity();
            orderItem.setAmount(amount);
        });
    }
    public void sumOfAmount() {
        Double totalAmount = 0D;
        for (OrderItem orderItem : this.getOrderItems())
            totalAmount += orderItem.getAmount();
        this.setAmount(totalAmount);
    }
    public void readyForPay() {
        payment = new Payment();
        payment.setId(id);
        payment.setAmount(amount);
        payment.setStatus("ready");
    }
    public void payoff(String method) {
        if(payment==null) readyForPay();
        payment.setMethod(method);
        payment.setStatus("payoff");
        payment.setPaymentTime(DateUtils.getNow());
        this.status = "payoff";
    }
}
