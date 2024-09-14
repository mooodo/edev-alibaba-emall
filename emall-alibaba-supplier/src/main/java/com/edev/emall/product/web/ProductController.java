package com.edev.emall.product.web;

import com.edev.emall.product.entity.Brand;
import com.edev.emall.product.entity.Product;
import com.edev.emall.product.entity.ProductCategory;
import com.edev.emall.product.service.BrandService;
import com.edev.emall.product.service.ProductCategoryService;
import com.edev.emall.product.service.ProductService;
import com.edev.support.entity.ResultSet;
import com.edev.support.query.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("create")
    public Long create(@RequestBody Product product) {
        return productService.create(product);
    }
    @PostMapping("modify")
    public void modify(@RequestBody Product product) {
        productService.modify(product);
    }
    @GetMapping("remove")
    public void remove(Long productId) {
        productService.remove(productId);
    }
    @GetMapping("load")
    public Product load(Long productId) {
        return productService.load(productId);
    }
    @Autowired @Qualifier("productQry")
    private QueryService queryService;
    @PostMapping("query")
    public ResultSet query(Map<String, Object> params) {
        return queryService.query(params);
    }
    @Autowired
    private BrandService brandService;
    @GetMapping("loadAllBrand")
    public Collection<Brand> loadAllBrand() {
        return brandService.loadAll();
    }
    @Autowired
    private ProductCategoryService productCategoryService;
    @GetMapping("loadAllCategory")
    public Collection<ProductCategory> loadAllCategory() {
        return productCategoryService.loadAll();
    }
}
