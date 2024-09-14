package com.edev.emall.customer.service.impl;

import com.edev.emall.customer.entity.Country;
import com.edev.emall.customer.service.CountryService;
import com.edev.support.dao.BasicDao;

import java.util.Collection;

public class CountryServiceImpl implements CountryService {
    private final BasicDao dao;

    public CountryServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    @Override
    public Country load(Long countryId) {
        return dao.load(countryId, Country.class);
    }

    @Override
    public boolean exists(Long countryId) {
        return load(countryId) != null;
    }

    @Override
    public Collection<Country> loadAll() {
        return dao.loadAll(new Country());
    }
}
