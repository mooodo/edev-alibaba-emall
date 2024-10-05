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
    public QueryDao customerQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.emall.customer.entity.Customer",
                "com.edev.emall.query.dao.CustomerMapper");
    }
    @Bean
    public QueryService customerQry() {
        return new AutofillQueryServiceImpl(
                customerQryDao(), repositoryWithCache);
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
}
