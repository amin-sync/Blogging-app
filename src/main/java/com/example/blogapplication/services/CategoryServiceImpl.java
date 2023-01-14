package com.example.blogapplication.services;

import com.example.blogapplication.exceptions.ResourceNotFoundException;
import com.example.blogapplication.models.Category;
import com.example.blogapplication.payloads.CategoryDto;
import com.example.blogapplication.repositories.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);


        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {

        //in below logic first we check the  existing data if it is present then we will update it otherwise exception will through
        Category cat = this.categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

        //Now we are saving the data because we found the existing data

        //setting data manually
        cat.setTitle(categoryDto.getTitle());
        cat.setDescription(categoryDto.getDescription());
//        cat.setId(categoryDto.getId()); // we are not changing ID

        Category updatedCat = this.categoryRepo.save(cat);
        //we want data in return of FTO form so we convert updatedCat in CategoryDto.Class
        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer id) {
        // first get the id and then delete it
        Category cat = this.categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        this.categoryRepo.delete(cat);

    }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        //first find the id then convert that id into categoryDto using model mapper
        Category cat = this.categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        return this.modelMapper.map(cat, CategoryDto.class);

    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        // we cant return categories directly because its return type is LIST so we will use stream api to convert each item
        List<CategoryDto> catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
        return catDtos;

    }
}
