package com.nvhuy.inventoryproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SupplierDto extends PageDto{
    private String name;
    private String email;
    private String phone;
    private String address;
}
