package com.edev.emall.event.entity;

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
}
