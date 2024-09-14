package com.edev.emall.customer.service;

import com.edev.emall.customer.entity.Country;

import java.util.Collection;

public interface CountryService {
    Country load(Long countryId);
    boolean exists(Long countryId);
    Collection<Country> loadAll();
}
