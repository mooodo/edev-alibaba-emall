package com.edev.emall.vip.web;

import com.edev.emall.vip.entity.PointsRule;
import com.edev.emall.vip.entity.UpgradeRule;
import com.edev.emall.vip.entity.Vip;
import com.edev.emall.vip.service.PointsRuleService;
import com.edev.emall.vip.service.UpgradeRuleService;
import com.edev.emall.vip.service.VipService;
import com.edev.support.entity.ResultSet;
import com.edev.support.query.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("vip")
public class VipController {
    @Autowired
    private VipService vipService;
    @PostMapping("register")
    public Long register(@RequestBody Vip vip) {
        return vipService.register(vip);
    }
    @PostMapping("modify")
    public void modify(@RequestBody Vip vip) {
        vipService.modify(vip);
    }
    @GetMapping("remove")
    public void remove(Long vipId) {
        vipService.remove(vipId);
    }
    @GetMapping("load")
    public Vip load(Long vipId) {
        return vipService.load(vipId);
    }
    @Autowired @Qualifier("vipQry")
    private QueryService queryService;
    @PostMapping("query")
    public ResultSet query(Map<String, Object> params) {
        return queryService.query(params);
    }
    @Autowired
    private PointsRuleService pointsRuleService;
    @GetMapping
    public Collection<PointsRule> loadAllPointsRule() {
        return pointsRuleService.loadAll();
    }
    @Autowired
    private UpgradeRuleService upgradeRuleService;
    @GetMapping("loadAllUpgradeRule")
    public Collection<UpgradeRule> loadAllUpgradeRule() {
        return upgradeRuleService.loadAll();
    }
}
