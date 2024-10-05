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
                userQryDao(), repositoryWithCache);
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
                roleDao(), repositoryWithCache);
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
                authorityDao(), repositoryWithCache);
    }
}
