package com.edev.emall.supplier.service;

import com.edev.emall.supplier.entity.Staff;

import java.util.Collection;

public interface StaffService {
    Long create(Staff staff);
    void modify(Staff staff);
    void remove(Long staffId);
    Staff load(Long staffId);
    Collection<Staff> loadBySupplier(Long supplierId);
    boolean existsOfTheSupplier(Long supplierId);
}
