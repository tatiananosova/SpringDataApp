package com.example.springdataapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Component
public class Cart {
    private List<Product> cart = new ArrayList<>();

    @Bean
    @Scope("singleton")
    public Cart cartSingleton() {
        return new Cart();
    }

    public void addToCart(Product product) {
        cart.add(product);
    }
}
