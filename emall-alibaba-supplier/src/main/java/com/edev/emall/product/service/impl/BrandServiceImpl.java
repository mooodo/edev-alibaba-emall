package com.edev.emall.product.service.impl;

import com.edev.emall.product.entity.Brand;
import com.edev.emall.product.service.BrandService;
import com.edev.support.dao.BasicDao;

import java.util.Collection;

public class BrandServiceImpl implements BrandService {
    private final BasicDao dao;
    public BrandServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    @Override
    public Brand load(Long brandId) {
        return dao.load(brandId, Brand.class);
    }

    @Override
    public boolean exists(Long brandId) {
        return load(brandId)!=null;
    }

    @Override
    public Collection<Brand> loadAll() {
        return dao.loadAll(new Brand());
    }
}
