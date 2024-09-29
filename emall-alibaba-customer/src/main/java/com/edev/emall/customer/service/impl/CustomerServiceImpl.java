package com.edev.emall.customer.service.impl;

import com.edev.emall.customer.entity.Address;
import com.edev.emall.customer.entity.Customer;
import com.edev.emall.customer.service.CustomerService;
import com.edev.support.dao.BasicDao;
import com.edev.support.utils.DateUtils;

import java.util.Collection;

import static com.edev.emall.utils.ValidUtils.isNull;

public class CustomerServiceImpl implements CustomerService {
    private final BasicDao dao;
    public CustomerServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    private void valid(Customer customer) {
        isNull(customer, "customer");
        isNull(customer.getId(), "id");
        isNull(customer.getName(), "name");
    }
    @Override
    public Long register(Customer customer) {
        valid(customer);
        customer.setCreateTime(DateUtils.getNow());
        return dao.insert(customer);
    }

    @Override
    public void modify(Customer customer) {
        valid(customer);
        customer.setModifyTime(DateUtils.getNow());
        dao.update(customer);
    }

    @Override
    public void remove(Long customerId) {
        dao.delete(customerId, Customer.class);
    }

    @Override
    public Customer load(Long customerId) {
        return dao.load(customerId, Customer.class);
    }

    @Override
    public boolean exists(Long customerId) {
        return load(customerId)!=null;
    }

    @Override
    public void removeByName(String name) {
        Customer template = new Customer();
        template.setName(name);
        dao.delete(template);
    }

    @Override
    public Customer loadByName(String name) {
        Customer template = new Customer();
        template.setName(name);
        Collection<Customer> customers = dao.loadAll(template);
        if (customers==null||customers.isEmpty()) return null;
        return customers.iterator().next();
    }

    @Override
    public Collection<Customer> loadForList(Collection<Long> customerIds) {
        return dao.loadForList(customerIds, Customer.class);
    }

    @Override
    public Address loadAddress(Long addressId) {
        return dao.load(addressId, Address.class);
    }

    @Override
    public boolean existsAddress(Long addressId) {
        return loadAddress(addressId)!=null;
    }

    @Override
    public Collection<Address> loadAddressForList(Collection<Long> addressIds) {
        return dao.loadForList(addressIds, Address.class);
    }
}
