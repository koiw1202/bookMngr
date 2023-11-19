package com.example.book.controller;

import com.example.book.model.BookDto;
import com.example.book.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService ;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "")
    public void insertBook(@RequestBody BookDto bookDto) {
        bookService.insertBook(bookDto);
    }

}
