package com.bookMngr.domain.book.repository;

import com.bookMngr.common.code.BookStatusCd;
import com.bookMngr.domain.book.model.BookInfoDto;
import com.bookMngr.domain.book.model.UpdateBookStatusDto;
import com.bookMngr.domain.book.model.response.SelectBookResultDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import static com.bookMngr.domain.book.domain.QBook.book;
import static com.bookMngr.domain.bookCategory.domain.QBookCategoryRelation.bookCategoryRelation;
import static com.bookMngr.domain.category.domain.QCategory.category;
import static org.springframework.util.StringUtils.hasText;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-28        koiw1       최초 생성
 */
public class BookRepositoryImpl implements BookRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory ;

    public BookRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public BooleanExpression bookStatusEq(BookStatusCd bookStatusCd) {
        return hasText(bookStatusCd.getCode()) ? book.bookStatus.eq(bookStatusCd.getCode()) : null ;
    }

    public BooleanExpression titleNameEq(String titleName) {
        return hasText(titleName) ? (book.title.eq(titleName)) : null ;
    }

    public BooleanExpression writerName(String writer) {
        return hasText(writer) ? book.writer.eq(writer) : null ;
    }

    public BooleanExpression bookIdEq(Long bookId){
        return hasText(String.valueOf(bookId)) ? book.bookId.eq(bookId) : null ;
    }

    @Override
    public List<SelectBookResultDto> selectBookInfo(BookInfoDto bookInfoDto) {
        return jpaQueryFactory
                .select(Projections.bean(SelectBookResultDto.class,
                        book.bookId
                        ,book.writer
                        ,book.title
                        ,category.categoryId
                        ,category.categoryNm
                ))
                .from(book)

                .innerJoin(bookCategoryRelation)
                .on(bookCategoryRelation.bookCategoryRelationPK.book.bookId.eq(book.bookId))

                .innerJoin(category)
                .on(category.categoryId.eq(bookCategoryRelation.bookCategoryRelationPK.category.categoryId))

                .where(bookStatusEq(BookStatusCd.BOOK_STATUS_OK)
                        .and(titleNameEq(bookInfoDto.getTitle()))
                        .and(writerName(bookInfoDto.getWriter()))
                )
                .offset((bookInfoDto.getPageNo() -1) * bookInfoDto.getPageSize())
                .limit(bookInfoDto.getPageSize())
                .fetch() ;
    }

    @Override
    public long updateBookStatus(UpdateBookStatusDto updateBookStatusDto) {
        return jpaQueryFactory.update(book)
                .set(book.bookStatus, updateBookStatusDto.getBookStatusCd())
                .where(bookIdEq(updateBookStatusDto.getBookId()))
                .execute() ;
    }
}
