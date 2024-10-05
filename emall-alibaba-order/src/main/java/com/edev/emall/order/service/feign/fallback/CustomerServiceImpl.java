package com.edev.emall.order.service.feign.fallback;

import com.edev.emall.customer.entity.Address;
import com.edev.emall.customer.entity.Customer;
import com.edev.emall.order.service.feign.CustomerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer load(Long customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName("Unknown");
        return customer;
    }

    @Override
    public boolean exists(Long customerId) {
        return false;
    }

    @Override
    public Collection<Customer> loadForList(List<Long> customerIds) {
        List<Customer> customers = new ArrayList<>();
        if(customerIds!=null)
            customerIds.forEach(customerId->customers.add(load(customerId)));
        return customers;
    }

    @Override
    public Address loadAddress(Long addressId) {
        Address address = new Address();
        address.setId(addressId);
        address.setDetailAddress("Unknown");
        return address;
    }

    @Override
    public boolean existsAddress(Long addressId) {
        return false;
    }

    @Override
    public Collection<Address> loadAddressForList(List<Long> addressIds) {
        List<Address> addresses = new ArrayList<>();
        if(addressIds!=null)
            addressIds.forEach(addressId->addresses.add(loadAddress(addressId)));
        return addresses;
    }
}
