package com.edev.emall.customer.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Account extends Entity<Long> {
    private Long id;
    private Double balance;
    private Date createTime;
    private Date modifyTime;
    private Customer customer;

    public void setBalance(Double balance) {
        this.balance = (balance == null) ? 0D : balance;
    }
}
