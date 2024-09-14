package com.edev.emall.customer.service.impl;

import com.edev.emall.customer.entity.Province;
import com.edev.emall.customer.service.ProvinceService;
import com.edev.support.dao.BasicDao;

import java.util.Collection;

public class ProvinceServiceImpl implements ProvinceService {
    private final BasicDao dao;

    public ProvinceServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    @Override
    public Province load(Long provinceId) {
        return dao.load(provinceId, Province.class);
    }

    @Override
    public boolean exists(Long provinceId) {
        return load(provinceId) != null;
    }

    @Override
    public Collection<Province> loadAll() {
        return dao.loadAll(new Province());
    }
}
