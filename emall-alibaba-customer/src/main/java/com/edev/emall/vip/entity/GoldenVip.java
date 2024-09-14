package com.edev.emall.vip.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoldenVip extends Vip {
    private String image;
    private Double creditLimit;
}
