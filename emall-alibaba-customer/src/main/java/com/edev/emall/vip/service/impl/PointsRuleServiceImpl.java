package com.edev.emall.vip.service.impl;

import com.edev.emall.vip.entity.PointsRule;
import com.edev.emall.vip.service.PointsRuleService;
import com.edev.support.dao.BasicDao;

import java.util.Collection;

public class PointsRuleServiceImpl implements PointsRuleService {
    private final BasicDao dao;

    public PointsRuleServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    @Override
    public PointsRule load(Long ruleId) {
        return dao.load(ruleId, PointsRule.class);
    }

    @Override
    public boolean exists(Long ruleId) {
        return load(ruleId) != null;
    }

    @Override
    public Collection<PointsRule> loadAll() {
        return dao.loadAll(new PointsRule());
    }
}
