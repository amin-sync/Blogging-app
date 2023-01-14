package com.example.blogapplication.services;

import com.example.blogapplication.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //Create

    CategoryDto createCategory(CategoryDto categoryDto);


    //Update

    CategoryDto updateCategory(CategoryDto categoryDto, Integer id);

    //Delete
    void deleteCategory(Integer id);

    //Get
    CategoryDto getCategoryById(Integer id);

    //GetAll
    List<CategoryDto> getCategories();
}
