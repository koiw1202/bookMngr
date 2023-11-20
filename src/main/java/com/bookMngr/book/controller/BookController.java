package com.bookMngr.book.controller;

import com.bookMngr.book.model.BookDto;
import com.bookMngr.book.model.SelectBookDto;
import com.bookMngr.book.model.response.SelectBookResultDto;
import com.bookMngr.book.service.BookService;
import com.bookMngr.common.CCConst;
import com.bookMngr.common.code.BookSearchType;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.common.response.ApiResponse;
import com.querydsl.core.BooleanBuilder;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class BookController {

    private final BookService bookService ;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "책 등록" , description = "책 등록 API")
    @PostMapping(value = "/book")
    public ApiResponse insertBook(@RequestBody BookDto bookDto) throws ErrorHandler {

        if(bookService.insertBook(bookDto))
            return ApiResponse.ok(CCConst.MERGE_SUCCESS) ;

        else
            throw new ErrorHandler(ErrorCode.BOOK_ERROR_002) ;
    }

    @Operation(summary = "책 조회" , description = "책 조회 API")
    @GetMapping(value = "/book")
    public ApiResponse selectBook(@RequestParam(required = true) Integer pageNo,
                                  @RequestParam(required = true) Integer pageSize,
                                  @RequestParam(required = true) String searchType ,
                                  @RequestParam(required = false) String writer ,
                                  @RequestParam(required = false) String title ,
                                  @RequestParam(required = false) Long categoryId) throws ErrorHandler {

        switch (BookSearchType.convertCodeToType(searchType)) {
            case TITLE_NAME -> {
                Optional.ofNullable(title)
                        .orElseThrow(() -> new ErrorHandler(ErrorCode.BOOK_ERROR_004)) ;
            }
            case WRITER_NAME -> {
                Optional.ofNullable(writer)
                        .orElseThrow(() -> new ErrorHandler(ErrorCode.BOOK_ERROR_005)) ;
            }
            case CATEGORY_ID -> {
                Optional.ofNullable(categoryId)
                        .orElseThrow(() -> new ErrorHandler(ErrorCode.BOOK_ERROR_006)) ;
            }
        }

        List<SelectBookResultDto> resultList =
                bookService.selectBook(SelectBookDto.builder()
                                                    .pageNo(pageNo)
                                                    .pageSize(pageSize)
                                                    .categoryId(categoryId)
                                                    .searchType(searchType)
                                                    .title(title)
                                                    .writer(writer).build()) ;

        if(resultList != null && resultList.size() > 0 )
            return ApiResponse.ok(CCConst.SELECT_SUCCESS, resultList) ;

        else
            return ApiResponse.ok(CCConst.NO_DATA) ;
    }


}
