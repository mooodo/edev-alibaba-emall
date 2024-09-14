package com.edev.emall.order.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Customer extends Entity<Long> {
    private Long id;
    private String name;
    private String gender;
    private String email;
    private String identification;
    private Date birthdate;
    private String phoneNumber;
    private Date createTime;
    private Date modifyTime;
}