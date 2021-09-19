package com.example.springdataapp.service;

import com.example.springdataapp.dto.CategoryDto;
import com.example.springdataapp.model.Category;
import com.example.springdataapp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                String.format("category with id - %s was not found", id)));
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.findByCategoryName(name);
    }
}
