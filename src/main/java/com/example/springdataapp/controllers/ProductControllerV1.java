package com.example.springdataapp.controllers;

import com.example.springdataapp.model.Product;
import com.example.springdataapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductControllerV1 {
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(Long id) {
        //TODO
    }

    @GetMapping("/{id}/delete")
    public void deleteProductById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/search_by_title")
    public Product searchByTitle(@RequestParam String title) {
        return productRepository.findByTitle(title).orElseThrow();
    }

    @GetMapping("/search_by_title_like")
    public List<Product> searchByTitleLike(@RequestParam String titleLike) {
        return productRepository.findAllByTitleIsContaining(titleLike);
    }

    @GetMapping("/search_by_cost_between")
    public List<Product> searchByCostBetween(@RequestParam int min, @RequestParam int max) {
        return productRepository.findAllByCostBetween(min, max);
    }

    @GetMapping("/search_by_cost_after")
    public List<Product> searchByCostAfter(@RequestParam int cost) {
        return productRepository.findAllByCostAfter(cost);
    }

    @GetMapping("/search_by_cost_before")
    public List<Product> searchByCostBefore(@RequestParam int cost) {
        return productRepository.findAllByCostBefore(cost);
    }
}
