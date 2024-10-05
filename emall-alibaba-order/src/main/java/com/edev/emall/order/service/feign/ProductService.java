package com.edev.emall.order.service.feign;

import com.edev.emall.order.service.feign.fallback.ProductServiceImpl;
import com.edev.emall.product.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Service
@FeignClient(value = "emall-supplier", fallback = ProductServiceImpl.class)
public interface ProductService {
    @GetMapping("orm/product/load")
    Product load(@RequestParam Long productId);
    @GetMapping("orm/product/exists")
    boolean exists(@RequestParam Long productId);
    @PostMapping("list/product/loadForList")
    Collection<Product> loadForList(@RequestBody List<Long> productIds);
}
