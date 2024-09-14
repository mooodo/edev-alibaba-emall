package com.edev.emall.vip.service.impl;

import com.edev.emall.customer.service.CustomerService;
import com.edev.emall.vip.dao.VipRuleDao;
import com.edev.emall.vip.entity.PointsRule;
import com.edev.emall.vip.entity.UpgradeRule;
import com.edev.emall.vip.entity.Vip;
import com.edev.emall.vip.service.VipService;
import com.edev.support.dao.BasicDao;
import com.edev.support.exception.ValidException;
import com.edev.support.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static com.edev.emall.utils.ValidUtils.isNotExists;
import static com.edev.emall.utils.ValidUtils.isNull;

public class VipServiceImpl implements VipService {
    private final BasicDao dao;
    public VipServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    @Autowired
    private CustomerService customerService;
    private void valid(Vip vip) {
        isNotExists(vip.getId(), (customerId)-> customerService.exists(customerId), "the customer of the vip");
    }
    @Override
    public Long register(Vip vip) {
        valid(vip);
        vip.setCreateTime(DateUtils.getNow());
        if(vip.getVipLevel()==null) vip.setVipLevel("silver");
        if(vip.getPoints()==null) vip.setPoints(0D);
        if(vip.getAccumulatedPoints()==null) vip.setAccumulatedPoints(0D);
        return dao.insert(vip);
    }

    @Override
    public void modify(Vip vip) {
        valid(vip);
        vip.setModifyTime(DateUtils.getNow());
        dao.update(vip);
    }

    @Override
    public void remove(Long vipId) {
        dao.delete(vipId, Vip.class);
    }

    @Override
    public Vip load(Long vipId) {
        return dao.load(vipId, Vip.class);
    }

    @Override
    public boolean exists(Long vipId) {
        return load(vipId)!=null;
    }

    @Override
    public Vip loadByCustomer(Long customerId) {
        return load(customerId);
    }

    @Autowired
    private VipRuleDao vipRuleDao;
    @Override
    public void accumulatePoints(Long vipId, Double amount) {
        Vip vip = load(vipId);
        if(vip==null) return;
        PointsRule pointsRule = vipRuleDao.getPointsRule(amount);
        if(pointsRule==null) return;
        Double points = pointsRule.calculatePoints(amount);
        vip.setPoints(vip.getPoints() + points);
        vip.setAccumulatedPoints(vip.getAccumulatedPoints() + points);
        upgradeVipLevel(vip);
        modify(vip);
    }

    private void upgradeVipLevel(Vip vip) {
        UpgradeRule upgradeRule = vipRuleDao.getUpgradeRule(vip.getAccumulatedPoints());
        if(upgradeRule==null) return;
        String vipLevel = upgradeRule.getVipLevel();
        vip.setVipLevel(vipLevel);
    }

    @Override
    public Double redeemPoints(Long vipId, Double points) {
        Vip vip = load(vipId);
        isNull(vip, "The vip is not exists");
        isNull(vip.getPoints(), "No points of the vip");
        Double result = vip.getPoints()-points;
        if(result < 0) throw new ValidException("Not enough the points of the vip");
        vip.setPoints(result);
        modify(vip);
        return result;
    }
}
