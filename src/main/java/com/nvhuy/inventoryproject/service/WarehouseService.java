package com.nvhuy.inventoryproject.service;

import com.nvhuy.inventoryproject.entity.Warehouse;
import com.nvhuy.inventoryproject.model.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    public Warehouse save(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }
}
