package com.bookMngr.book.service;

import com.bookMngr.book.domain.Book;
import com.bookMngr.book.model.BookDto;
import com.bookMngr.book.model.SelectBookDto;
import com.bookMngr.book.model.UpdateBookStatusDto;
import com.bookMngr.book.model.response.SelectBookResultDto;
import com.bookMngr.book.repository.BookRepository;
import com.bookMngr.category.domain.Category;
import com.bookMngr.common.code.BookSearchType;
import com.bookMngr.common.code.BookStatusCd;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.bookCategory.domain.BookCategoryRelation;
import com.bookMngr.bookCategory.domain.BookCategoryRelationPK;
import com.bookMngr.bookCategory.repository.BookCategoryRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.bookMngr.book.domain.QBook.book ;
import static com.bookMngr.category.domain.QCategory.category;
import static com.bookMngr.bookCategory.domain.QBookCategoryRelation.bookCategoryRelation;


@Service
@RequiredArgsConstructor
public class BookService {

    private final JPAQueryFactory jpaQueryFactory ;
    private final BookRepository bookRepository;
    private final BookCategoryRepository bookCategoryRepo ;

    @Transactional(rollbackFor = {ErrorHandler.class, Exception.class}, propagation = Propagation.REQUIRED)
    public boolean insertBook(final BookDto bookDto) {

        Book saveBookResult = bookRepository.save(
            Book.builder()
                .title(bookDto.getTitle())
                .writer(bookDto.getWriter())
                .bookStatus(BookStatusCd.BOOK_STATUS_OK.getCode())
                .build()) ;

        Optional.ofNullable(saveBookResult)
                .ifPresentOrElse(value -> {

                    Book book = new Book(value.getBookId()) ;
                    Category category = new Category(bookDto.getCategoryId()) ;
                    BookCategoryRelationPK bookCategoryRelationPK = new BookCategoryRelationPK(book, category) ;

                    try {
                        bookCategoryRepo.save(
                                BookCategoryRelation.builder()
                                        .bookCategoryRelationPK(bookCategoryRelationPK)
                                        .build()
                        ) ;
                    } catch(Exception e) {
                        throw new ErrorHandler(ErrorCode.BOOK_ERROR_002, e.getMessage()) ;
                    }
                }, () -> {
                    throw new ErrorHandler(ErrorCode.BOOK_ERROR_001) ;
                });

        return true ;
    }

    public List<SelectBookResultDto> getBookInfo(SelectBookDto selectBookDto) {

        BooleanBuilder builder = new BooleanBuilder();

//      대여가능 상태인 항목으로 filtering
        builder.and(book.bookStatus.eq(BookStatusCd.BOOK_STATUS_OK.getCode())) ;

        switch (BookSearchType.convertCodeToType(selectBookDto.getSearchType())) {
            case CATEGORY_ID -> builder.and(category.categoryId.eq(selectBookDto.getCategoryId())) ;
            case TITLE_NAME -> builder.and(book.title.contains(selectBookDto.getTitle())) ;
            case WRITER_NAME -> builder.and(book.writer.contains(selectBookDto.getWriter())) ;
        }

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

                .where(builder)
                .offset((selectBookDto.getPageNo() -1) * selectBookDto.getPageSize() )
                .limit(selectBookDto.getPageSize())
                .fetch() ;
    }

    @Transactional
    public boolean setBookStatus(UpdateBookStatusDto updateBookStatusDto) {

        long result = jpaQueryFactory.update(book)
                                    .set(book.bookStatus, updateBookStatusDto.getBookStatusCd())
                                    .where(book.bookId.eq(updateBookStatusDto.getBookId()))
                                    .execute() ;

        if(result == 1)
            return true ;
        else
            return false ;

    }

}