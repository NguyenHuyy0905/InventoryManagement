package com.nvhuy.inventoryproject.service;

import com.nvhuy.inventoryproject.entity.Supplier;
import com.nvhuy.inventoryproject.model.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> findAll(String sortName, int direction) {
        Sort.Direction sortDirection = Sort.Direction.ASC;
        if (direction == -1) {
            sortDirection = Sort.Direction.DESC;
        }
        Sort sort = Sort.by(sortDirection, sortName);
        return supplierRepository.findAll(sort);
    }
}
