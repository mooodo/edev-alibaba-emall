package com.edev.emall.customer.web;

import com.edev.emall.customer.entity.*;
import com.edev.emall.customer.service.*;
import com.edev.support.entity.ResultSet;
import com.edev.support.query.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @PostMapping("register")
    @PreAuthorize("hasAuthority('customer')")
    public Long register(Customer customer) {
        return service.register(customer);
    }
    @PostMapping("modify")
    @PreAuthorize("hasAuthority('customer')")
    public void modify(Customer customer) {
        service.modify(customer);
    }
    @GetMapping("remove")
    @PreAuthorize("hasAuthority('customer')")
    public void remove(Long customerId) {
        service.remove(customerId);
    }
    @GetMapping("load")
    @PreAuthorize("hasAuthority('customer')")
    public Customer load(Long customerId) {
        return service.load(customerId);
    }
    @Autowired @Qualifier("customerQry")
    private QueryService queryService;
    @PostMapping("query")
    public ResultSet query(@RequestBody Map<String, Object> params) {
        return queryService.query(params);
    }
    @Autowired
    private CountryService countryService;
    @GetMapping("loadAllCountry")
    public Collection<Country> loadAllCountry() {
        return countryService.loadAll();
    }
    @Autowired
    private ProvinceService provinceService;
    @GetMapping("loadAllProvince")
    public Collection<Province> loadAllProvince() {
        return provinceService.loadAll();
    }
    @Autowired
    private CityService cityService;
    @GetMapping("loadAllCity")
    public Collection<City> loadAllCity() {
        return cityService.loadAll();
    }
    @Autowired
    private DistrictService districtService;
    @GetMapping("loadAllDistrict")
    public Collection<District> loadAllDistrict() {
        return districtService.loadAll();
    }
}
