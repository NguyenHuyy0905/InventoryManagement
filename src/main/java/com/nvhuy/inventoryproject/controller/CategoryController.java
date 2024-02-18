package com.nvhuy.inventoryproject.controller;

import com.nvhuy.inventoryproject.dto.CategoryDto;
import com.nvhuy.inventoryproject.entity.Category;
import com.nvhuy.inventoryproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody Category category) {
        categoryService.save(category);
        return ResponseEntity.ok("Save successfully!!");
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestBody CategoryDto categoryDto) {
        List<Category> categoryList = categoryService.findAll(categoryDto.getPageNumber(), categoryDto.getPageSize()).toList();
        return ResponseEntity.ok(categoryList);
    }
}
