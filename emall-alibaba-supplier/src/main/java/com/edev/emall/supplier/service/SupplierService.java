package com.edev.emall.supplier.service;

import com.edev.emall.supplier.entity.Supplier;

public interface SupplierService {
    Long create(Supplier supplier);
    void modify(Supplier supplier);
    void remove(Long supplierId);
    Supplier load(Long supplierId);
    boolean exists(Long supplierId);
}
