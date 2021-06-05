package com.example.springdataapp.service;

import com.example.springdataapp.model.Product;
import com.example.springdataapp.repository.ProductRepository;
import com.example.springdataapp.service.specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> findAll(Map<String, String> params, Integer pageNumber, Integer pageSize) {
        final Specification<Product> specification = ProductSpecification.build(params);
        return productRepository.findAll(specification, PageRequest.of(pageNumber-1,pageSize));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                String.format("product with id - %s was not found", id)));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product findByTitle(String title) {
        return productRepository.findByTitle(title).orElseThrow();
    }

    public List<Product> findAllByTitleIsContaining(String titleLike) {
        return productRepository.findAllByTitleIsContaining(titleLike);
    }

    public List<Product> findAllByCostBetween(int min, int max) {
        return productRepository.findAllByCostBetween(min,max);
    }

    public List<Product> findAllByCostAfter(int cost) {
        return productRepository.findAllByCostAfter(cost);
    }

    public List<Product> findAllByCostBefore(int cost) {
        return productRepository.findAllByCostBefore(cost);
    }
}
