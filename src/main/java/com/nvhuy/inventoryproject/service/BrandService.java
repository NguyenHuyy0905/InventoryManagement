package com.nvhuy.inventoryproject.service;

import com.nvhuy.inventoryproject.entity.Brand;
import com.nvhuy.inventoryproject.model.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

//    public void deleteBrandById(int id) {
//        brandRepository.deleteById(id);
//    }

    public ResponseEntity<String> deleteBrandById(Integer id) {
        Optional<Brand> foundBrand = brandRepository.findById(id);
        if (foundBrand.isPresent()) {
            brandRepository.deleteById(id);
            return ResponseEntity.ok("Brand with id " + id + " has been deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Brand with id " + id + " not found.");
        }
    }
}
