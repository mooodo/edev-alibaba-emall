package com.edev.emall.order.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Payment extends Entity<Long> {
    private Long id;
    private Double amount;
    private String method;
    private String status;
    private Date paymentTime;
}
