package com.bookMngr.category.service;

import com.bookMngr.category.domain.Category;
import com.bookMngr.category.model.CategoryDto;
import com.bookMngr.category.repository.CategoryRepo;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.common.error.ErrorMessage;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.bookMngr.category.domain.QCategory.category;


@Service
public class CategoryService {

    private final JPAQueryFactory jpaQueryFactory ;
    private final CategoryRepo categoryRepo ;

    public CategoryService(JPAQueryFactory jpaQueryFactory, CategoryRepo categoryRepo) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.categoryRepo = categoryRepo;
    }

    public boolean insertCategory(final CategoryDto categoryDto) {
        CategoryDto categoryExist =
                jpaQueryFactory
                        .select(Projections.bean(CategoryDto.class,
                                category.categoryNm))
                        .from(category)
                        .where(category.categoryNm.eq(categoryDto.getCategoryNm()))
                        .fetchOne() ;

        Optional.ofNullable(categoryExist)
                .ifPresentOrElse(vo -> {
                    throw new ErrorHandler(ErrorCode.CATEGORY_ERROR_002) ;
                }, () -> {
                    try {
                        categoryRepo.save(Category.builder()
                                .categoryNm(categoryDto.getCategoryNm()).build()
                        ) ;
                    } catch(Exception e) {
                        throw new ErrorHandler(ErrorCode.BOOK_ERROR_002, e.getMessage()) ;
                    }

                });

        return true ;
    }

}
