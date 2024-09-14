package com.edev.emall.inventory.service.impl;

import com.edev.emall.inventory.entity.InventoryRecord;
import com.edev.emall.inventory.service.InventoryRecordService;
import com.edev.support.dao.BasicDao;

public class InventoryRecordServiceImpl implements InventoryRecordService {
    private final BasicDao dao;
    public InventoryRecordServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    @Override
    public void insert(InventoryRecord inventoryRecord) {
        dao.insert(inventoryRecord);
    }

    @Override
    public void remove(Long recordId) {
        dao.delete(recordId, InventoryRecord.class);
    }
}
