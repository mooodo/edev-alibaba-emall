package com.edev.emall.customer.service.impl;

import com.edev.emall.customer.entity.City;
import com.edev.emall.customer.service.CityService;
import com.edev.support.dao.BasicDao;

import java.util.Collection;

public class CityServiceImpl implements CityService {
    private final BasicDao dao;

    public CityServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    @Override
    public City load(Long cityId) {
        return dao.load(cityId, City.class);
    }

    @Override
    public boolean exists(Long cityId) {
        return load(cityId) != null;
    }

    @Override
    public Collection<City> loadAll() {
        return dao.loadAll(new City());
    }
}
