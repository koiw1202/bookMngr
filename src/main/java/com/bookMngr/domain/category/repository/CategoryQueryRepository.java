package com.bookMngr.domain.category.repository;

import com.bookMngr.domain.category.model.CategoryDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import static com.bookMngr.domain.category.domain.QCategory.category;

/**
 * description    : category 관련 querydsl 로직을 담당하는 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-28        koiw1       최초 생성
 */
@Repository
public class CategoryQueryRepository {

    private final JPAQueryFactory jpaQueryFactory ;

    public CategoryQueryRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public CategoryDto selectSingleCategory(CategoryDto categoryDto) {
        return jpaQueryFactory
                .select(Projections.bean(CategoryDto .class,
                        category.categoryNm))
                .from(category)
                .where(category.categoryNm.eq(categoryDto.getCategoryNm()))
                .fetchOne() ;
    }


}
