package com.edev.emall.order.service.feign.fallback;

import com.edev.emall.order.entity.Vip;
import com.edev.emall.order.service.feign.VipService;
import org.springframework.stereotype.Component;

@Component
public class VipServiceImpl implements VipService {
    @Override
    public Vip load(Long vipId) {
        Vip vip = new Vip();
        vip.setId(vipId);
        return vip;
    }

    @Override
    public boolean exists(Long vipId) {
        return false;
    }

    @Override
    public Vip loadByCustomer(Long customerId) {
        return load(customerId);
    }
}
