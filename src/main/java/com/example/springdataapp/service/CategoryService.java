package com.example.springdataapp.service;

import com.example.springdataapp.dto.CategoryDto;
import com.example.springdataapp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDto::fromCategory).collect(Collectors.toList());
    }
}
