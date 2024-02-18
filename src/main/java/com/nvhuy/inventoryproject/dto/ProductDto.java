package com.nvhuy.inventoryproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nvhuy.inventoryproject.entity.Brand;
import com.nvhuy.inventoryproject.entity.Category;
import com.nvhuy.inventoryproject.entity.Supplier;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto extends PageDto{
    private String name;
    private Double priceImport;
    private Double minPriceImport;
    private Double maxPriceImport;
    private Double priceSell;
    private Double minPriceSell;
    private Double maxPriceSell;
    private Double discount;
    private Double minDiscount;
    private Double maxDiscount;
    private String imageUrl;
    private String description;
    private Integer quantity;
    private Integer minQuantity;
    private Integer maxQuantity;
    private String warranty;
    private String categoryName;
    private String brandName;
    private String supplierName;
}
