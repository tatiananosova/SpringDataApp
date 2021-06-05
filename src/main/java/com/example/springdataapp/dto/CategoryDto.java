package com.example.springdataapp.dto;

import com.example.springdataapp.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private String category;

    public static CategoryDto fromCategory(Category category) {
        return new CategoryDto(category.getCategory());
    }
}
