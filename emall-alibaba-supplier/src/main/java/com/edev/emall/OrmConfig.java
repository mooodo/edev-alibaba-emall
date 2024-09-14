package com.edev.emall;

import com.edev.emall.inventory.service.InventoryRecordService;
import com.edev.emall.inventory.service.InventoryService;
import com.edev.emall.inventory.service.impl.InventoryRecordServiceImpl;
import com.edev.emall.inventory.service.impl.InventoryServiceImpl;
import com.edev.emall.product.service.BrandService;
import com.edev.emall.product.service.ProductCategoryService;
import com.edev.emall.product.service.ProductService;
import com.edev.emall.product.service.impl.BrandServiceImpl;
import com.edev.emall.product.service.impl.ProductCategoryServiceImpl;
import com.edev.emall.product.service.impl.ProductServiceImpl;
import com.edev.emall.supplier.service.StaffService;
import com.edev.emall.supplier.service.SupplierService;
import com.edev.emall.supplier.service.impl.StaffServiceImpl;
import com.edev.emall.supplier.service.impl.SupplierServiceImpl;
import com.edev.support.dao.BasicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrmConfig {
    @Autowired @Qualifier("basicDao")
    private BasicDao basicDao;
    @Autowired @Qualifier("basicDaoWithCache")
    private BasicDao basicDaoWithCache;
    @Autowired @Qualifier("repository")
    private BasicDao repository;
    @Autowired @Qualifier("repositoryWithCache")
    private BasicDao repositoryWithCache;
    @Bean
    public ProductService product() {
        return new ProductServiceImpl(repositoryWithCache);
    }
    @Bean
    public ProductCategoryService productCategory() {
        return new ProductCategoryServiceImpl(basicDaoWithCache);
    }
    @Bean
    public BrandService brand() {
        return new BrandServiceImpl(basicDaoWithCache);
    }
    @Bean
    public SupplierService supplier() {
        return new SupplierServiceImpl(repositoryWithCache);
    }
    @Bean
    public StaffService staff() {
        return new StaffServiceImpl(repository);
    }
    @Bean
    public InventoryService inventory() {
        return new InventoryServiceImpl(basicDao);
    }
    @Bean
    public InventoryRecordService inventoryRecord() {
        return new InventoryRecordServiceImpl(basicDao);
    }
}
