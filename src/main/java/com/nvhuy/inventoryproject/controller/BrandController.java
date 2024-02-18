package com.nvhuy.inventoryproject.controller;

import com.nvhuy.inventoryproject.entity.Brand;
import javax.validation.Valid;
import com.nvhuy.inventoryproject.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/brand")
@Validated
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Brand brand) {
        try {
            Brand savedBrand = brandService.save(brand);
            return ResponseEntity.ok(savedBrand);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi khi lưu dữ liệu.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrandById(@PathVariable Integer id) {
        try {
            return brandService.deleteBrandById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the brand.");
        }
    }
}
