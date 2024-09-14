package com.edev.emall.authority.service.impl;

import com.edev.emall.authority.entity.Authority;
import com.edev.emall.authority.service.AuthorityService;
import com.edev.emall.utils.ValidUtils;
import com.edev.support.dao.BasicDao;

public class AuthorityServiceImpl implements AuthorityService {
    private final BasicDao dao;
    public AuthorityServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    private void valid(Authority authority) {
        ValidUtils.isNull(authority, "authority");
        ValidUtils.isNull(authority.getId(), "id");
        ValidUtils.isNull(authority.getName(), "name");
    }
    @Override
    public Long create(Authority authority) {
        valid(authority);
        return dao.insert(authority);
    }

    @Override
    public void modify(Authority authority) {
        valid(authority);
        dao.update(authority);
    }

    @Override
    public void remove(Long authorityId) {
        dao.delete(authorityId, Authority.class);
    }

    @Override
    public Authority load(Long authorityId) {
        return dao.load(authorityId, Authority.class);
    }
}
