package com.edev.emall.product.service;

import com.edev.emall.product.entity.Brand;

import java.util.Collection;

public interface BrandService {
    Brand load(Long brandId);
    boolean exists(Long brandId);
    Collection<Brand> loadAll();
}
