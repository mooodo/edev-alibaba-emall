package com.edev.emall.supplier.web;

import com.edev.emall.supplier.entity.Staff;
import com.edev.emall.supplier.service.StaffService;
import com.edev.support.entity.ResultSet;
import com.edev.support.query.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @PostMapping("create")
    public Long create(@RequestBody Staff staff) {
        return staffService.create(staff);
    }
    @PostMapping("modify")
    public void modify(@RequestBody Staff staff) {
        staffService.modify(staff);
    }
    @GetMapping("remove")
    public void remove(Long staffId) {
        staffService.remove(staffId);
    }
    @GetMapping("load")
    public Staff load(Long staffId) {
        return staffService.load(staffId);
    }
    @Autowired @Qualifier("staffQry")
    private QueryService queryService;
    @PostMapping("query")
    public ResultSet query(Map<String, Object> params) {
        return queryService.query(params);
    }
}
