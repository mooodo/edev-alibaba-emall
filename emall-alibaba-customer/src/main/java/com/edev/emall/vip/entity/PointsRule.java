package com.edev.emall.vip.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PointsRule extends Entity<Long> {
    private Long id;
    private Double pointsPerYuan; // 每消费一定金额获得的积分数
    private Double pointsCap; // 单次购买可获得的积分上限

    // 计算积分的方法
    public Double calculatePoints(Double amount) {
        if(amount==null||pointsPerYuan==null||pointsPerYuan==0D) return 0D;
        double points = amount / pointsPerYuan;
        return Math.min(points, pointsCap); // 返回积分，但不能超过上限
    }
}