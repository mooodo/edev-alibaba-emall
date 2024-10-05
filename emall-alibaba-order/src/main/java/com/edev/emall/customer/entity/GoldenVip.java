package com.edev.emall.customer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoldenVip extends Vip {
    private String image;
    private Double creditLimit;
}
