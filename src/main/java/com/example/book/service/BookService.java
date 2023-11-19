package com.example.book.service;

import com.example.book.domain.Book;
import com.example.book.domain.BookPK;
import com.example.book.model.BookDto;
import com.example.book.repository.BookRepo;
import com.example.common.code.BookStatusCd;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final JPAQueryFactory queryFactory ;
    private final BookRepo bookRepo ;

    public BookService(JPAQueryFactory queryFactory, BookRepo bookRepo) {
        this.queryFactory = queryFactory;
        this.bookRepo = bookRepo;
    }

    public void insertBook(final BookDto bookDto) {

        Object result = bookRepo.save(
            Book.builder()
                .title(bookDto.getTitle())
                .writer(bookDto.getWriter())
                .bookPK(BookPK.builder().categoryId(bookDto.getCategoryId()).build())
                .bookStatus(BookStatusCd.BOOK_STATUS_OK.getCode())
                .build()) ;

        System.out.println(result) ;

    }



}
