package com.edev.emall.supplier.service.impl;

import com.edev.emall.supplier.entity.Supplier;
import com.edev.emall.supplier.service.StaffService;
import com.edev.emall.supplier.service.SupplierService;
import com.edev.support.dao.BasicDao;
import com.edev.support.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static com.edev.emall.utils.ValidUtils.*;

public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private StaffService staffService;
    private final BasicDao dao;
    public SupplierServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    private void valid(Supplier supplier) {
        isNull(supplier.getName(), "the name of the supplier");
    }

    @Override
    public Long create(Supplier supplier) {
        valid(supplier);
        supplier.setCreateTime(DateUtils.getNow());
        return dao.insert(supplier);
    }

    @Override
    public void modify(Supplier supplier) {
        valid(supplier);
        supplier.setModifyTime(DateUtils.getNow());
        dao.update(supplier);
    }

    @Override
    public void remove(Long supplierId) {
        isExists(supplierId, (value)->staffService.existsOfTheSupplier(value), "the staff of the supplier");
        dao.delete(supplierId, Supplier.class);
    }

    @Override
    public Supplier load(Long supplierId) {
        return dao.load(supplierId, Supplier.class);
    }

    @Override
    public boolean exists(Long supplierId) {
        return load(supplierId) != null;
    }
}
