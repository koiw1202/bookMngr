package com.example.category.controller;

import com.example.category.model.CategoryDto;
import com.example.category.service.CategoryService;
import com.example.common.error.ErrorHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CategoryController {

    private final CategoryService categoryService ;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/category")
    public void insertCategory(@Valid @RequestBody final CategoryDto categoryDto) throws ErrorHandler {

        categoryService.insertCategory(categoryDto) ;

    }
}
