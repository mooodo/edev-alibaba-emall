package com.edev.emall.supplier.entity;

import com.edev.emall.utils.EMallUtils;
import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Staff extends Entity<Long> {
    private Long id; // 主键ID
    private String name; // 员工姓名
    private String gender; // 性别
    private String identification; // 身份证号
    private Date birthdate; // 出生日期
    private String email; // 邮箱
    private String phoneNumber; // 电话号码
    private Long supplierId; // 所属供应商ID
    private Date createTime; // 注册时间
    private Date modifyTime; // 更新时间
    private Supplier supplier;

    public void setBirthdate(Date birthdate) {
        this.birthdate = (birthdate == null) ?
                EMallUtils.getBirthdateFromIdentification(this.identification) : birthdate;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
        this.birthdate = EMallUtils.getBirthdateFromIdentification(identification);
    }
}
