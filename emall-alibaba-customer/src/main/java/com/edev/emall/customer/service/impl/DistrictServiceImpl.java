package com.edev.emall.customer.service.impl;

import com.edev.emall.customer.entity.District;
import com.edev.emall.customer.service.DistrictService;
import com.edev.support.dao.BasicDao;

import java.util.Collection;

public class DistrictServiceImpl implements DistrictService {
    private final BasicDao dao;

    public DistrictServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    @Override
    public District load(Long districtId) {
        return dao.load(districtId, District.class);
    }

    @Override
    public boolean exists(Long districtId) {
        return load(districtId) != null;
    }

    @Override
    public Collection<District> loadAll() {
        return dao.loadAll(new District());
    }
}
