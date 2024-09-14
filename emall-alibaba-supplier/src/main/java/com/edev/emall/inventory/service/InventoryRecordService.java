package com.edev.emall.inventory.service;

import com.edev.emall.inventory.entity.InventoryRecord;

public interface InventoryRecordService {
    void insert(InventoryRecord inventoryRecord);
    void remove(Long recordId);
}
