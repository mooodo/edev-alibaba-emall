package com.edev.emall;

import com.edev.emall.order.service.DiscountService;
import com.edev.emall.order.service.OrderService;
import com.edev.emall.order.service.impl.DiscountServiceImpl;
import com.edev.emall.order.service.impl.OrderServiceImpl;
import com.edev.support.dao.BasicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrmConfig {
    @Autowired @Qualifier("repository")
    private BasicDao repository;
    @Bean
    public OrderService order() {
        return new OrderServiceImpl(repository);
    }
    @Bean
    public DiscountService discount() {
        return new DiscountServiceImpl(repository);
    }
}
