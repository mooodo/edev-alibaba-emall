package com.edev.emall.product.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Brand extends Entity<Long> {
    private Long id;
    private String name;
    private String description;
}
