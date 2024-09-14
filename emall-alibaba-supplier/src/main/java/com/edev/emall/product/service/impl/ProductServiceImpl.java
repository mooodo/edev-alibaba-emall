package com.edev.emall.product.service.impl;

import com.edev.emall.product.entity.Product;
import com.edev.emall.product.service.ProductCategoryService;
import com.edev.emall.product.service.ProductService;
import com.edev.emall.supplier.service.SupplierService;
import com.edev.support.dao.BasicDao;
import com.edev.support.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

import static com.edev.emall.utils.ValidUtils.*;

public class ProductServiceImpl implements ProductService {
    private final BasicDao dao;
    public ProductServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ProductCategoryService productCategoryService;
    private void valid(Product product) {
        isNull(product.getName(), "the name of the product");
        isNull(product.getPrice(), "the price of the product");
        isNotExists(product.getSupplierId(), (value)->supplierService.exists(value), "the supplier of the product");
        isNotExists(product.getCategoryId(), (value)->productCategoryService.exists(value), "the category of the product");
    }
    @Override
    public Long create(Product product) {
        valid(product);
        product.setCreateTime(DateUtils.getNow());
        return dao.insert(product);
    }

    @Override
    public void modify(Product product) {
        valid(product);
        product.setModifyTime(DateUtils.getNow());
        dao.update(product);
    }

    @Override
    public void remove(Long productId) {
        dao.delete(productId, Product.class);
    }

    @Override
    public Product load(Long productId) {
        return dao.load(productId, Product.class);
    }

    @Override
    public boolean exists(Long productId) {
        return load(productId)!=null;
    }

    @Override
    public Collection<Product> loadForList(List<Long> productIds) {
        return dao.loadForList(productIds, Product.class);
    }
}
