package com.example.springdataapp.controllers;

import com.example.springdataapp.dto.CategoryDto;
import com.example.springdataapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }


}
