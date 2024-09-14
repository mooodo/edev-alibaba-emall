package com.edev.emall.customer.service;

import com.edev.emall.customer.entity.City;

import java.util.Collection;

public interface CityService {
    City load(Long cityId);
    boolean exists(Long cityId);
    Collection<City> loadAll();
}
