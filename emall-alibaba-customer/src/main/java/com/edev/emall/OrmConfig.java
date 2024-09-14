package com.edev.emall;

import com.edev.emall.customer.service.*;
import com.edev.emall.customer.service.impl.*;
import com.edev.emall.vip.service.PointsRuleService;
import com.edev.emall.vip.service.UpgradeRuleService;
import com.edev.emall.vip.service.VipService;
import com.edev.emall.vip.service.impl.PointsRuleServiceImpl;
import com.edev.emall.vip.service.impl.UpgradeRuleServiceImpl;
import com.edev.emall.vip.service.impl.VipServiceImpl;
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
    public CustomerService customer() {
        return new CustomerServiceImpl(repositoryWithCache);
    }
    @Bean
    public AccountService account() {
        return new AccountServiceImpl(repository);
    }
    @Bean
    public JournalAccountService journalAccount() {
        return new JournalAccountServiceImpl(basicDao);
    }
    @Bean
    public CountryService country() {
        return new CountryServiceImpl(basicDaoWithCache);
    }
    @Bean
    public ProvinceService province() {
        return new ProvinceServiceImpl(basicDaoWithCache);
    }
    @Bean
    public CityService city() {
        return new CityServiceImpl(basicDaoWithCache);
    }
    @Bean
    public DistrictService district() {
        return new DistrictServiceImpl(basicDaoWithCache);
    }
    @Bean
    public VipService vip() {
        return new VipServiceImpl(repository);
    }
    @Bean
    public PointsRuleService pointsRule() {
        return new PointsRuleServiceImpl(basicDaoWithCache);
    }
    @Bean
    public UpgradeRuleService upgradeRule() {
        return new UpgradeRuleServiceImpl(basicDaoWithCache);
    }
}
