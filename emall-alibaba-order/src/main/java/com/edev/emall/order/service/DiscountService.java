package com.edev.emall.order.service;

import com.edev.emall.order.entity.Discount;
import com.edev.emall.order.entity.Order;

public interface DiscountService {
    Long create(Discount discount);
    void modify(Discount discount);
    void delete(Discount template);
    void deleteById(Long discountId);
    void doDiscount(Order order);
    Discount loadById(Long discountId);
    Discount load(Discount template);
}
