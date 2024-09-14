package com.edev.emall.order.service.feign;

import com.edev.emall.order.entity.Address;
import com.edev.emall.order.entity.Customer;
import com.edev.emall.order.service.feign.fallback.CustomerServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Service
@FeignClient(value = "emall-customer", fallback = CustomerServiceImpl.class)
public interface CustomerService {
    @GetMapping("orm/customer/load")
    Customer load(@RequestParam Long customerId);
    @GetMapping("orm/customer/exists")
    boolean exists(@RequestParam Long customerId);
    @PostMapping("list/customer/loadForList")
    Collection<Customer> loadForList(@RequestBody List<Long> customerIds);
    @GetMapping("orm/customer/loadAddress")
    Address loadAddress(@RequestParam Long addressId);
    @GetMapping("orm/customer/existsAddress")
    boolean existsAddress(@RequestParam Long addressId);
    @PostMapping("list/customer/loadAddressForList")
    Collection<Address> loadAddressForList(@RequestBody List<Long> addressIds);
}
