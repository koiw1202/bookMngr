package com.bookMngr.domain.bookStore.controller;

import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.common.response.ApiResponse;
import com.bookMngr.domain.bookStore.model.dto.BookStoreDtoForInsertion;
import com.bookMngr.domain.bookStore.service.BookStoreService;
import com.bookMngr.domain.bookStore.service.dto.BookStoreQuantityInfoDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        koiw1       최초 생성
 */
@RestController
@RequiredArgsConstructor
public class BookStoreController {

    private final BookStoreService bookStoreService ;

    @Operation(summary = "매장-책 정보 조회" , description = "매장 내의 책 수량 정보 조회")
    @GetMapping("/v1.0.0/bookStore/{storeCd}")
    public HttpEntity getBookStoreQuantityInfo(@PathVariable Long storeCd) throws ErrorHandler {

        BookStoreQuantityInfoDto bookStoreQuantityInfoDto = bookStoreService.getBookStoreQuantityInfo(storeCd) ;

        return Optional.ofNullable(bookStoreQuantityInfoDto)
                .map(v -> ApiResponse.ok(CCConst.SELECT_SUCCESS,bookStoreQuantityInfoDto))
                .orElseThrow(() -> new ErrorHandler(CCConst.SELECT_FAIL, CCConst.FAIL_CODE)) ;
    }

    @Operation(summary = "매장-책 정보 입력" , description = "매장 내의 책 수량 정보 입력")
    @PostMapping("/v1.0.0/bookStore")
    public HttpEntity insertBookStoreQuantityInfo(final BookStoreDtoForInsertion bookStoreDtoForInsertion) throws ErrorHandler {

        Integer result ;
        try {
            result = bookStoreService.insertBookStoreQuantityInfo(bookStoreDtoForInsertion) ;
        } catch(Exception e) {
            throw new ErrorHandler(ErrorCode.STORE_ERROR_005) ;
        }

        return Optional.ofNullable(result)
                .filter(v-> v.equals(CCConst.OK_CODE_FOR_CUD))
                .map(v -> ApiResponse.ok(CCConst.UPDATE_SUCCESS, null))
                .orElseThrow(() -> new ErrorHandler(CCConst.MERGE_FAIL, CCConst.FAIL_CODE)) ;
    }

}
