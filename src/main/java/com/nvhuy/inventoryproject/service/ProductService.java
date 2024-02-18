package com.nvhuy.inventoryproject.service;

import com.nvhuy.inventoryproject.dto.ProductDto;
import com.nvhuy.inventoryproject.entity.Product;
import com.nvhuy.inventoryproject.model.ProductRepository;
import com.nvhuy.inventoryproject.model.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> searchProducts(ProductDto criteria) {
        return productRepository.findAll(ProductSpecification.searchProducts(criteria));
    }
}
