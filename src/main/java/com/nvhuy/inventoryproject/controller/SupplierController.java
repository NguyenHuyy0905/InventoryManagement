package com.nvhuy.inventoryproject.controller;

import com.nvhuy.inventoryproject.dto.SupplierDto;
import com.nvhuy.inventoryproject.entity.Supplier;
import com.nvhuy.inventoryproject.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@Validated
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Supplier supplier) {
        try {
            Supplier savedSupplier = supplierService.save(supplier);
            return ResponseEntity.ok(savedSupplier);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi khi lưu dữ liệu.");
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllWithSort(@RequestParam String nameSort, @RequestParam int directionSort) {
        List<Supplier> suppliers = supplierService.findAll(nameSort, directionSort);
        return ResponseEntity.ok(suppliers);
    }
}
