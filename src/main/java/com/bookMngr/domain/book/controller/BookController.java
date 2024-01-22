package com.bookMngr.domain.book.controller;

import com.bookMngr.common.code.BookSearchType;
import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.common.response.ApiResponse;
import com.bookMngr.domain.book.model.BookDto;
import com.bookMngr.domain.book.model.BookInfoDto;
import com.bookMngr.domain.book.model.UpdateBookStatusDto;
import com.bookMngr.domain.book.model.response.SelectBookResultDto;
import com.bookMngr.domain.book.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class BookController {

    private final BookService bookService ;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "책 등록" , description = "책 등록 API")
    @PostMapping(value = "/v1.0.0/book")
    public HttpEntity insertBook(@Valid @RequestBody BookDto bookDto) throws ErrorHandler {

        if(bookService.insertBook(bookDto))
            return ApiResponse.ok(CCConst.MERGE_SUCCESS, null) ;

        else
            throw new ErrorHandler(ErrorCode.BOOK_ERROR_002) ;
    }

    @Operation(summary = "책 조회" , description = "책 조회 API")
    @GetMapping(value = "/v1.0.0/book")
    public HttpEntity selectBook(@RequestParam(required = true) Integer pageNo,
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
                bookService.getBookInfo(BookInfoDto.builder()
                                                    .pageNo(pageNo)
                                                    .pageSize(pageSize)
                                                    .categoryId(categoryId)
                                                    .searchType(searchType)
                                                    .title(title)
                                                    .writer(writer).build()) ;

        if(resultList != null && resultList.size() > 0 )
            return ApiResponse.ok(CCConst.SELECT_SUCCESS, resultList) ;

        else
            return ApiResponse.ok(CCConst.NO_DATA, null) ;
    }

    @Operation(summary = "책 상태 변경" , description = "책 상태 변경 API")
    @PutMapping(value = "/v1.0.0/book")
    public HttpEntity updateBookStatus(@Valid @RequestBody UpdateBookStatusDto updateBookStatusDto) throws ErrorHandler {

        if(this.bookService.setBookStatus(updateBookStatusDto))
            return ApiResponse.ok(CCConst.UPDATE_SUCCESS, null) ;
        else
            throw new ErrorHandler(ErrorCode.BOOK_ERROR_008) ;
    }

}


























