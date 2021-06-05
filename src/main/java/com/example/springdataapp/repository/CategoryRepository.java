package com.example.springdataapp.repository;

import com.example.springdataapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryName(String name);
}
