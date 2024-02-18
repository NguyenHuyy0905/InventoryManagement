package com.nvhuy.inventoryproject.service;

import com.nvhuy.inventoryproject.entity.Role;
import com.nvhuy.inventoryproject.model.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
