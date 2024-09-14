package com.edev.emall.vip.service;

import com.edev.emall.vip.entity.UpgradeRule;

import java.util.Collection;

public interface UpgradeRuleService {
    UpgradeRule load(Long ruleId);
    boolean exists(Long ruleId);
    Collection<UpgradeRule> loadAll();
}
