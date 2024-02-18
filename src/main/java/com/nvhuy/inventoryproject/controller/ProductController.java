package com.nvhuy.inventoryproject.controller;

import com.nvhuy.inventoryproject.dto.ProductDto;
import com.nvhuy.inventoryproject.entity.Product;
import com.nvhuy.inventoryproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Product product) {
        try {
            Product savedProduct = productService.save(product);
            return ResponseEntity.ok(savedProduct);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi trong quá trình lưu.");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchProducts(@RequestBody ProductDto criteria) {
        return new ResponseEntity<>(productService.searchProducts(criteria), HttpStatus.OK);
    }
}
