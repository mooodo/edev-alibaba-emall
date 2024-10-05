package com.edev.emall.order.service.feign.fallback;

import com.edev.emall.order.service.feign.ProductService;
import com.edev.emall.product.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Override
    public Product load(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setName("Unknown");
        return product;
    }

    @Override
    public boolean exists(Long productId) {
        return false;
    }

    @Override
    public Collection<Product> loadForList(List<Long> productIds) {
        List<Product> products = new ArrayList<>();
        productIds.forEach(productId->products.add(load(productId)));
        return products;
    }
}
