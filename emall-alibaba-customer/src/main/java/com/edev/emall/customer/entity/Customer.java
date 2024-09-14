package com.edev.emall.customer.entity;

import com.edev.emall.utils.EMallUtils;
import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

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
    private List<Address> addresses;

    public void setBirthdate(Date birthdate) {
        this.birthdate = (birthdate == null) ?
                EMallUtils.getBirthdateFromIdentification(this.identification) : birthdate;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
        this.birthdate = EMallUtils.getBirthdateFromIdentification(identification);
    }
}