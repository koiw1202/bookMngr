package com.bookMngr.category.controller;

import com.bookMngr.category.model.CategoryDto;
import com.bookMngr.category.service.CategoryService;
import com.bookMngr.common.CCConst;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "카테고리 등록" , description = "카테고리 등록 API")
    @PostMapping(value = "/v1.0.0/category")
    public ApiResponse insertCategory(@Valid @RequestBody final CategoryDto categoryDto) throws ErrorHandler {

        if(categoryService.insertCategory(categoryDto))
            return ApiResponse.ok(CCConst.MERGE_SUCCESS) ;

        else
            throw new ErrorHandler(ErrorCode.CATEGORY_ERROR_001) ;


    }
}
