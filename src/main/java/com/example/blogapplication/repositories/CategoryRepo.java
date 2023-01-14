package com.example.blogapplication.repositories;

import com.example.blogapplication.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
