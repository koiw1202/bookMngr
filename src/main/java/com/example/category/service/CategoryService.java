package com.example.category.service;

import com.example.category.domain.Category;
import com.example.category.model.CategoryDto;
import com.example.category.repository.CategoryRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class CategoryService {

    private final JPAQueryFactory jpaQueryFactory ;
    private final CategoryRepo categoryRepo ;

    public CategoryService(JPAQueryFactory jpaQueryFactory, CategoryRepo categoryRepo) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.categoryRepo = categoryRepo;
    }

    public void insertCategory(final CategoryDto categoryDto) {


        Category category = categoryRepo.save(
            Category.builder()
                    .categoryNm(categoryDto.getCategoryNm()).build()
        ) ;

        System.out.println(category) ;
    }

}
