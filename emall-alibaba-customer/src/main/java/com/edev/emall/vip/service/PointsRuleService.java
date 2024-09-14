package com.edev.emall.vip.service;

import com.edev.emall.vip.entity.PointsRule;

import java.util.Collection;

public interface PointsRuleService {
    PointsRule load(Long ruleId);
    boolean exists(Long ruleId);
    Collection<PointsRule> loadAll();
}
