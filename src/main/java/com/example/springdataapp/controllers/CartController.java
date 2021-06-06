package com.example.springdataapp.controllers;

import com.example.springdataapp.model.Product;
import com.example.springdataapp.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PutMapping("/{id}")
    public void addToCart(@PathVariable Long id) {
         cartService.addToCart(id);
    }

    @GetMapping
    public List<Product> getCart() {
        return cartService.getCart();
    }

    @GetMapping("/cost")
    public Integer getCartCost() {
        return cartService.getCartCost();
    }
}
