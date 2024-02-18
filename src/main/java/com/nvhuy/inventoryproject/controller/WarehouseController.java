package com.nvhuy.inventoryproject.controller;

import com.nvhuy.inventoryproject.entity.Warehouse;
import com.nvhuy.inventoryproject.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Warehouse warehouse) {
        try {
            Warehouse savedWarehouse = warehouseService.save(warehouse);
            return ResponseEntity.ok(savedWarehouse);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi khi lưu dữ liệu.");
        }
    }
}
