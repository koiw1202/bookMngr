package com.bookMngr.domain.category.service;

import com.bookMngr.domain.category.domain.Category;
import com.bookMngr.domain.category.model.CategoryDto;
import com.bookMngr.domain.category.repository.CategoryRepository;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.bookMngr.category.domain.QCategory.category;


@Service
public class CategoryService {

    private final JPAQueryFactory jpaQueryFactory ;
    private final CategoryRepository categoryRepo ;

    public CategoryService(JPAQueryFactory jpaQueryFactory, CategoryRepository categoryRepo) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.categoryRepo = categoryRepo;
    }

    @Transactional(rollbackFor = {ErrorHandler.class, Exception.class}, propagation = Propagation.REQUIRED)
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
