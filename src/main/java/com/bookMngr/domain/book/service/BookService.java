package com.bookMngr.domain.book.service;

import com.bookMngr.common.code.BookStatusCd;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.domain.book.domain.Book;
import com.bookMngr.domain.book.model.BookDto;
import com.bookMngr.domain.book.model.BookInfoDto;
import com.bookMngr.domain.book.model.UpdateBookStatusDto;
import com.bookMngr.domain.book.model.response.SelectBookResultDto;
import com.bookMngr.domain.book.repository.BookRepository;
import com.bookMngr.domain.bookCategory.domain.BookCategoryRelation;
import com.bookMngr.domain.bookCategory.domain.BookCategoryRelationPK;
import com.bookMngr.domain.bookCategory.repository.BookCategoryRepository;
import com.bookMngr.domain.category.domain.Category;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public List<SelectBookResultDto> getBookInfo(final BookInfoDto bookInfoDto) {

        return bookRepository.selectBookInfo(bookInfoDto) ;

    }

    @Transactional(rollbackFor = {ErrorHandler.class, Exception.class}, propagation = Propagation.REQUIRED)
    public boolean setBookStatus(final UpdateBookStatusDto updateBookStatusDto) {

        long result = bookRepository.updateBookStatus(updateBookStatusDto);

        if(result == 1)
            return true ;
        else
            return false ;

    }

}