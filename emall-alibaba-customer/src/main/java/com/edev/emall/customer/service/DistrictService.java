package com.edev.emall.customer.service;

import com.edev.emall.customer.entity.District;

import java.util.Collection;

public interface DistrictService {
    District load(Long districtId);
    boolean exists(Long districtId);
    Collection<District> loadAll();
}
