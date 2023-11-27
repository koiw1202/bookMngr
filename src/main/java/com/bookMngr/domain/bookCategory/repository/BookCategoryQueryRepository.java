package com.bookMngr.domain.bookCategory.repository;

import com.bookMngr.domain.bookCategory.model.BookCategoryRelationDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import static com.bookMngr.domain.bookCategory.domain.QBookCategoryRelation.bookCategoryRelation;

/**
 * description    : bookCategory 쿼리 로직 관련 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-28        koiw1       최초 생성
 */
@Repository
public class BookCategoryQueryRepository {

    private final JPAQueryFactory jpaQueryFactory ;


    public BookCategoryQueryRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public long updateBookCategoryRelation(BookCategoryRelationDto bookCategoryRelationDto) {
        return jpaQueryFactory.update(bookCategoryRelation)
                .set(bookCategoryRelation.bookCategoryRelationPK.category.categoryId, bookCategoryRelationDto.getCategoryId())
                .where(bookCategoryRelation.bookCategoryRelationPK.book.bookId.eq(bookCategoryRelationDto.getBookId()))
                .execute() ;
    }





}
