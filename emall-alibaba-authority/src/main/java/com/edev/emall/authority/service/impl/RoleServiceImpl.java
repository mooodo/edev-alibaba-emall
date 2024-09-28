package com.edev.emall.authority.service.impl;

import com.edev.emall.authority.entity.Role;
import com.edev.emall.authority.service.RoleService;
import com.edev.emall.utils.ValidUtils;
import com.edev.support.dao.BasicDao;

public class RoleServiceImpl implements RoleService {
    private final BasicDao dao;
    public RoleServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    private void valid(Role role) {
        ValidUtils.isNull(role, "role");
        ValidUtils.isNull(role.getId(), "id");
        ValidUtils.isNull(role.getName(), "name");
    }
    @Override
    public Long create(Role role) {
        valid(role);
        return dao.insert(role);
    }

    @Override
    public void modify(Role role) {
        valid(role);
        dao.update(role);
    }

    @Override
    public void remove(Long roleId) {
        dao.delete(roleId, Role.class);
    }

    @Override
    public Role load(Long roleId) {
        return dao.load(roleId, Role.class);
    }
}