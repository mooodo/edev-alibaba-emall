package com.edev.emall.inventory.service.impl;

import com.edev.emall.inventory.entity.Inventory;
import com.edev.emall.inventory.entity.InventoryRecord;
import com.edev.emall.inventory.service.InventoryRecordService;
import com.edev.emall.inventory.service.InventoryService;
import com.edev.support.dao.BasicDao;
import com.edev.support.exception.ValidException;
import com.edev.support.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRecordService inventoryRecordService;
    private final BasicDao dao;
    public InventoryServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    private void create(Inventory inventory) {
        dao.insert(inventory);
    }
    private void modify(Inventory inventory) {
        dao.update(inventory);
    }
    @Override
    @Transactional
    public void stockIn(Long productId, Integer quantity) {
        Inventory inventory = check(productId);
        if(inventory==null) {
            inventory = new Inventory();
            inventory.setId(productId);
            inventory.setQuantity(quantity);
            inventory.setUpdateTime(DateUtils.getNow());
            create(inventory);

            InventoryRecord record = new InventoryRecord();
            record.setProductId(productId);
            record.setQuantity(quantity);
            record.setOperation("stock in");
            record.setUpdateTime(DateUtils.getNow());
            inventoryRecordService.insert(record);
        } else {
            Integer currency = inventory.getQuantity();
            inventory.setQuantity(currency+quantity);
            inventory.setUpdateTime(DateUtils.getNow());
            modify(inventory);

            InventoryRecord record = new InventoryRecord();
            record.setProductId(productId);
            record.setQuantity(currency+quantity);
            record.setOperation("stock in");
            record.setUpdateTime(DateUtils.getNow());
            inventoryRecordService.insert(record);
        }
    }

    @Override
    @Transactional
    public void stockOut(Long productId, Integer quantity) {
        Inventory inventory = check(productId);
        if(inventory==null) throw new ValidException("No storage for the product: %d", productId);
        Integer currency = inventory.getQuantity();
        int result = currency-quantity;
        if(result<0) throw new ValidException("Out of storage for the product: %d", productId);
        inventory.setQuantity(result);
        inventory.setUpdateTime(DateUtils.getNow());
        modify(inventory);

        InventoryRecord record = new InventoryRecord();
        record.setProductId(productId);
        record.setQuantity(result);
        record.setOperation("stock out");
        record.setUpdateTime(DateUtils.getNow());
        inventoryRecordService.insert(record);
    }

    @Override
    public void remove(Long productId) {
        dao.delete(productId, Inventory.class);
    }

    @Override
    public Inventory check(Long productId) {
        return dao.load(productId, Inventory.class);
    }
}
