package com.nvhuy.inventoryproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageDto<T extends BaseDto> extends BaseDto {
    private List<T> items;
    private int pageNumber;
    private int pageSize;
    private long totalItems;
    private int totalPages;
    private int directionSort;
}
