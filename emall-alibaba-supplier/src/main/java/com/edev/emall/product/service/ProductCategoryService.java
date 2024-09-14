package com.edev.emall.product.service;

import com.edev.emall.product.entity.ProductCategory;

import java.util.Collection;

public interface ProductCategoryService {
    ProductCategory load(Long categoryId);
    boolean exists(Long categoryId);
    Collection<ProductCategory> loadAll();
}
