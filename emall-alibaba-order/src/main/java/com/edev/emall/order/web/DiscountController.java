package com.edev.emall.order.web;

import com.edev.emall.order.entity.Discount;
import com.edev.emall.order.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("discount")
public class DiscountController {
    @Autowired
    private DiscountService discountService;
    @PostMapping("create")
    public Long create(@RequestBody Discount discount) {
        return discountService.create(discount);
    }
    @PostMapping("modify")
    public void modify(@RequestBody Discount discount) {
        discountService.modify(discount);
    }
    @GetMapping("remove")
    public void remove(Long discountId) {
        discountService.deleteById(discountId);
    }
    @GetMapping("load")
    public Discount load(Long discountId) {
        return discountService.loadById(discountId);
    }
}
