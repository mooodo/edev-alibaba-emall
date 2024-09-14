package com.edev.emall.vip.service.impl;

import com.edev.emall.vip.entity.UpgradeRule;
import com.edev.emall.vip.service.UpgradeRuleService;
import com.edev.support.dao.BasicDao;

import java.util.Collection;

public class UpgradeRuleServiceImpl implements UpgradeRuleService {
    private final BasicDao dao;

    public UpgradeRuleServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    @Override
    public UpgradeRule load(Long ruleId) {
        return dao.load(ruleId, UpgradeRule.class);
    }

    @Override
    public boolean exists(Long ruleId) {
        return load(ruleId) != null;
    }

    @Override
    public Collection<UpgradeRule> loadAll() {
        return dao.loadAll(new UpgradeRule());
    }
}
