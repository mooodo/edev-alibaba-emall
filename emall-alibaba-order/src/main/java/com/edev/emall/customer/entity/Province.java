package com.edev.emall.customer.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Province extends Entity<Long> {
    private Long id;
    private String name;
    private Long countryId;
    private String provinceCode;
}
