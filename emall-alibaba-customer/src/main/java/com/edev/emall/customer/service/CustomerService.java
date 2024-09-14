package com.edev.emall.customer.service;

import com.edev.emall.customer.entity.Address;
import com.edev.emall.customer.entity.Customer;

import java.util.Collection;
import java.util.List;

public interface CustomerService {
    Long register(Customer customer);
    void modify(Customer customer);
    void remove(Long customerId);
    Customer load(Long customerId);
    boolean exists(Long customerId);
    void removeByName(String name);
    Customer loadByName(String name);
    Collection<Customer> loadForList(List<Long> customerIds);
    Address loadAddress(Long addressId);
    boolean existsAddress(Long addressId);
    Collection<Address> loadAddressForList(List<Long> addressIds);
}
