package com.edev.emall.supplier.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Supplier extends Entity<Long> {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private Date createTime; // 创建时间
    private Date modifyTime; // 更新时间
}
