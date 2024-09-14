package com.edev.emall.supplier.service.impl;

import com.edev.emall.supplier.entity.Staff;
import com.edev.emall.supplier.service.StaffService;
import com.edev.emall.supplier.service.SupplierService;
import com.edev.support.dao.BasicDao;
import com.edev.support.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static com.edev.emall.utils.ValidUtils.*;

public class StaffServiceImpl implements StaffService {
    private final BasicDao dao;
    public StaffServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    @Autowired
    private SupplierService supplierService;
    private void valid(Staff staff) {
        isNull(staff.getName(), "the name of the staff");
        isNotExists(staff.getSupplierId(), (value)->supplierService.exists(value), "the supplier of the staff");
    }
    @Override
    public Long create(Staff staff) {
        valid(staff);
        staff.setCreateTime(DateUtils.getNow());
        return dao.insert(staff);
    }

    @Override
    public void modify(Staff staff) {
        valid(staff);
        staff.setModifyTime(DateUtils.getNow());
        dao.update(staff);
    }

    @Override
    public void remove(Long staffId) {
        dao.delete(staffId, Staff.class);
    }

    @Override
    public Staff load(Long staffId) {
        return dao.load(staffId, Staff.class);
    }

    @Override
    public Collection<Staff> loadBySupplier(Long supplierId) {
        Staff template = new Staff();
        template.setSupplierId(supplierId);
        return dao.loadAll(template);
    }

    @Override
    public boolean existsOfTheSupplier(Long supplierId) {
        Collection<Staff> staffs = loadBySupplier(supplierId);
        return staffs!=null && !staffs.isEmpty();
    }
}
