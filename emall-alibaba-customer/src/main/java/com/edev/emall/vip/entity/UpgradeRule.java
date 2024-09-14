package com.edev.emall.vip.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpgradeRule extends Entity<Long> {
    private Long id;
    private String vipLevel;
    private Double pointsNeed;
}
