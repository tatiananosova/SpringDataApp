package com.example.springdataapp.dto;

import com.example.springdataapp.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

//FIXME use DTO
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer id;
    private String categoryName;
    private Set<ProductDto> productSet;

}
