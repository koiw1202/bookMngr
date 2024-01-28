package com.bookMngr.domain.category.repository;

import com.bookMngr.domain.category.model.CategoryDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.bookMngr.domain.category.domain.QCategory.category;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-28        koiw1       최초 생성
 */
public class CategoryRepositoryImpl implements CategoryRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory ;

    public CategoryRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public CategoryDto getSingleCategory(final CategoryDto categoryDto) {

        return jpaQueryFactory
                .select(Projections.bean(CategoryDto .class,
                        category.categoryNm))
                .from(category)
                .where(category.categoryNm.eq(categoryDto.getCategoryNm()))
                .fetchOne() ;

    }
}
