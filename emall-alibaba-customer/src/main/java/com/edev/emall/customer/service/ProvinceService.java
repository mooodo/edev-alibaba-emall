package com.edev.emall.customer.service;

import com.edev.emall.customer.entity.Province;

import java.util.Collection;

public interface ProvinceService {
    Province load(Long provinceId);
    boolean exists(Long provinceId);
    Collection<Province> loadAll();
}
