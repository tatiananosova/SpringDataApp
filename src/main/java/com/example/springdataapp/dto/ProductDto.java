package com.example.springdataapp.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Integer id;
    private String name;
    private Integer quantity;
    private Float price;
    private CategoryDto category;
}