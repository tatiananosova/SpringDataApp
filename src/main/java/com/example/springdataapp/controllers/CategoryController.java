package com.example.springdataapp.controllers;

import com.example.springdataapp.dto.CategoryDto;
import com.example.springdataapp.model.Category;
import com.example.springdataapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping(path="/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
}
