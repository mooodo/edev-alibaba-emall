package com.edev.emall.order.service.feign;

import com.edev.emall.customer.entity.Vip;
import com.edev.emall.order.service.feign.fallback.VipServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "emall-customer", fallback = VipServiceImpl.class)
public interface VipService {
    @GetMapping("orm/vip/load")
    Vip load(@RequestParam Long vipId);
    @GetMapping("orm/vip/exists")
    boolean exists(@RequestParam Long vipId);
    @GetMapping("orm/vip/loadByCustomer")
    Vip loadByCustomer(@RequestParam Long customerId);
}
