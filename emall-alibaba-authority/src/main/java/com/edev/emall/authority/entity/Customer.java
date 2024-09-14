package com.edev.emall.authority.entity;

import com.edev.support.utils.DateUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Customer extends User {
    private Long id;
    private String name;
    private String gender;
    private String email;
    private String identification;
    private Date birthdate;
    private String phoneNumber;
    private Date createTime;
    private Date modifyTime;

    public void setIdentification(String identification) {
        this.identification = identification;
        if(identification!=null) {
            String str = identification.substring(6, 14);
            String format = "yyyyMMdd";
            this.birthdate = DateUtils.getDate(str, format);
        }
    }
}