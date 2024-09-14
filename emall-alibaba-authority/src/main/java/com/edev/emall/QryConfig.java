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
    @Autowired @Qualifier("repositoryWithCache")
    private BasicDao repositoryWithCache;
    @Bean
    public QueryDao userQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.authority.entity.User",
                "com.edev.emall.query.dao.UserMapper");
    }
    @Bean
    public QueryService userQry() {
        return new AutofillQueryServiceImpl(
                userQryDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao roleDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.authority.entity.Role",
                "com.edev.emall.query.dao.RoleMapper");
    }
    @Bean
    public QueryService roleQry() {
        return new AutofillQueryServiceImpl(
                roleDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao authorityDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.authority.entity.Authority",
                "com.edev.emall.query.dao.AuthorityMapper");
    }
    @Bean
    public QueryService authorityQry() {
        return new AutofillQueryServiceImpl(
                authorityDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao customerQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.customer.entity.Customer",
                "com.edev.emall.query.dao.CustomerMapper");
    }
    @Bean
    public QueryService customerQry() {
        return new AutofillQueryServiceImpl(
                customerQryDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao accountQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.customer.entity.Account",
                "com.edev.emall.query.dao.AccountMapper");
    }
    @Bean
    public QueryService accountQry() {
        return new AutofillQueryServiceImpl(
                accountQryDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao journalAccountQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.customer.entity.JournalAccount",
                "com.edev.emall.query.dao.JournalAccountMapper");
    }
    @Bean
    public QueryService journalAccountQry() {
        return new QueryServiceImpl(journalAccountQryDao());
    }
    @Bean
    public QueryDao vipQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.vip.entity.Vip",
                "com.edev.emall.query.dao.VipMapper");
    }
    @Bean
    public QueryService vipQry() {
        return new AutofillQueryServiceImpl(
                vipQryDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao supplierQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.supplier.entity.Supplier",
                "com.edev.emall.query.dao.SupplierMapper");
    }
    @Bean
    public QueryService supplierQry() {
        return new AutofillQueryServiceImpl(
                supplierQryDao(), basicDaoWithCache);
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
    public QueryDao orderQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.order.entity.Order",
                "com.edev.emall.query.dao.OrderMapper");
    }
    @Bean
    public QueryService orderQry() {
        return new AutofillQueryServiceImpl(
                orderQryDao(), repositoryWithCache);
    }
}
