package com.edev.emall;

import com.edev.support.dao.BasicDao;
import com.edev.support.dao.QueryDao;
import com.edev.support.ddd.AutofillQueryServiceImpl;
import com.edev.support.ddd.QueryDaoMybastisImplForDdd;
import com.edev.support.query.QueryService;
import com.edev.support.query.impl.QueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QryConfig {
    @Autowired @Qualifier("basicDaoWithCache")
    private BasicDao basicDaoWithCache;
    @Bean
    public QueryDao supplierQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.supplier.entity.Supplier",
                "com.edev.emall.query.dao.SupplierMapper");
    }
    @Bean
    public QueryService supplierQry() {
        return new QueryServiceImpl(supplierQryDao());
    }
    @Bean
    public QueryDao staffQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.supplier.entity.Staff",
                "com.edev.emall.query.dao.StaffMapper");
    }
    @Bean
    public QueryService staffQry() {
        return new AutofillQueryServiceImpl(
                staffQryDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao productQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.product.entity.Product",
                "com.edev.emall.query.dao.ProductMapper");
    }
    @Bean
    public QueryService productQry() {
        return new AutofillQueryServiceImpl(
                productQryDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao inventoryQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.inventory.entity.Inventory",
                "com.edev.emall.query.dao.InventoryMapper"
        );
    }
    @Bean
    public QueryService inventoryQry() {
        return new QueryServiceImpl(inventoryQryDao());
    }

    @Bean
    public QueryDao inventoryRecordQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.inventory.entity.InventoryRecord",
                "com.edev.emall.query.dao.InventoryRecordMapper"
        );
    }
    @Bean
    public QueryService inventoryRecordQry() {
        return new QueryServiceImpl(inventoryRecordQryDao());
    }
}
