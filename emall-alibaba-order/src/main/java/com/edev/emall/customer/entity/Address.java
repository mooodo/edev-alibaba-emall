package com.edev.emall.customer.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Address extends Entity<Long> {
    private Long id;
    private Long customerId;
    private Long countryId;
    private Long provinceId;
    private Long cityId;
    private Long districtId;
    private String detailAddress;
    private String phoneNumber;
    private Integer isDefault;
    private Country country;
    private Province province;
    private City city;
    private District district;
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = (isDefault!=null&&isDefault) ? 1 : 0;
    }
    public Boolean getIsDefault() {
        return this.isDefault!=null&&this.isDefault==1;
    }
}
