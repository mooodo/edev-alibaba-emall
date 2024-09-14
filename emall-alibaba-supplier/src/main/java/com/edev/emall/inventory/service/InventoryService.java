package com.edev.emall.inventory.service;

import com.edev.emall.inventory.entity.Inventory;

public interface InventoryService {
    void stockIn(Long productId, Integer quantity);
    void stockOut(Long productId, Integer quantity);
    void remove(Long productId);
    Inventory check(Long productId);
}
