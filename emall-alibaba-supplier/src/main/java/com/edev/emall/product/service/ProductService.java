package com.edev.emall.product.service;

import com.edev.emall.product.entity.Product;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    Long create(Product product);
    void modify(Product product);
    void remove(Long productId);
    Product load(Long productId);
    boolean exists(Long productId);
    Collection<Product> loadForList(List<Long> productIds);
}
