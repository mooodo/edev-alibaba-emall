package com.edev.emall.vip.dao;

import com.edev.emall.vip.entity.PointsRule;
import com.edev.emall.vip.entity.UpgradeRule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VipRuleDao {
    @Select("select * from t_upgrade_rule where points_need < #{points} " +
            "order by points_need desc limit 1")
    @Results({
            @Result(column = "vip_level", property = "vipLevel"),
            @Result(column = "points_need", property = "pointsNeed")
    })
    UpgradeRule getUpgradeRule(Double points);
    @Select("select * from t_points_rule where points_cap > #{amount} " +
            "order by points_cap limit 1")
    @Results({
            @Result(column = "points_per_yuan", property = "pointsPerYuan"),
            @Result(column = "points_cap", property = "pointsCap")
    })
    PointsRule getPointsRule(Double amount);
}