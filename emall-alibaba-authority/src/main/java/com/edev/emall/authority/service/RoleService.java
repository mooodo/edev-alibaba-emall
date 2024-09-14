package com.edev.emall.authority.service;

import com.edev.emall.authority.entity.Role;

public interface RoleService {
    Long create(Role role);
    void modify(Role role);
    void remove(Long roleId);
    Role load(Long roleId);
}
