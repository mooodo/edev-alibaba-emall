package com.edev.emall.inventory.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class InventoryRecord extends Entity<Long> {
    private Long id;
    private Long productId;
    private Integer quantity;
    private Date updateTime;
    private String operation;
}
