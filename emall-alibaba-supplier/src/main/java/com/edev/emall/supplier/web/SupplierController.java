package com.edev.emall.supplier.web;

import com.edev.emall.supplier.entity.Supplier;
import com.edev.emall.supplier.service.SupplierService;
import com.edev.support.entity.ResultSet;
import com.edev.support.query.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @PostMapping("create")
    public Long create(@RequestBody Supplier supplier) {
        return supplierService.create(supplier);
    }
    @PostMapping("modify")
    public void modify(@RequestBody Supplier supplier) {
        supplierService.modify(supplier);
    }
    @GetMapping("remove")
    public void remove(Long supplierId) {
        supplierService.remove(supplierId);
    }
    @GetMapping("load")
    public Supplier load(Long supplierId) {
        return supplierService.load(supplierId);
    }
    @Autowired @Qualifier("supplierQry")
    private QueryService queryService;
    @PostMapping("query")
    public ResultSet query(Map<String, Object> params) {
        return queryService.query(params);
    }
}
