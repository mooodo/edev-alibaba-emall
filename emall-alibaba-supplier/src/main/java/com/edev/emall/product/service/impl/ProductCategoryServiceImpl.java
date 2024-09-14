package com.edev.emall.product.service.impl;

import com.edev.emall.product.entity.ProductCategory;
import com.edev.emall.product.service.ProductCategoryService;
import com.edev.support.dao.BasicDao;

import java.util.Collection;

public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final BasicDao dao;
    public ProductCategoryServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    @Override
    public ProductCategory load(Long categoryId) {
        return dao.load(categoryId, ProductCategory.class);
    }

    @Override
    public boolean exists(Long categoryId) {
        return load(categoryId)!=null;
    }

    @Override
    public Collection<ProductCategory> loadAll() {
        return dao.loadAll(new ProductCategory());
    }
}
