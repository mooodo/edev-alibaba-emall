package com.edev.emall.order.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Vip extends Entity<Long> {
    private Long id;
    private Date createTime;
    private Date modifyTime;
    private String vipLevel; // 会员等级，如银卡、金卡、白金卡
    private Long points; // 会员当前的积分总数
    private Long accumulatedPoints; // 购买商品后累积的积分总数
    private Customer customer;
}
