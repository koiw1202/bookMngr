package com.bookMngr.domain.bookCategory.controller;

import com.bookMngr.domain.bookCategory.model.BookCategoryRelationDto;
import com.bookMngr.domain.bookCategory.service.BookCategoryRelationService;
import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.bookMngr.relation.bookCategory.controller
 * fileName       : BookCategoryRelationController
 * author         : FIC08709
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        FIC08709       최초 생성
 */

@RestController
@AllArgsConstructor
public class BookCategoryRelationController {

    private final BookCategoryRelationService bookCategoryRelationService ;

    @Operation(summary = "책 - 카테고리 연관관계 변경" , description = "책 - 카테고리 연관관계 변경")
    @PutMapping("/v1.0.0/bookCategoryRelation")
    public HttpEntity updateBookCategoryRelation(BookCategoryRelationDto bookCategoryRelationDto) throws ErrorHandler {

        if(bookCategoryRelationService.updateBookCategoryRelation(bookCategoryRelationDto))
            return ApiResponse.ok(CCConst.MERGE_SUCCESS, null) ;

        else
            throw new ErrorHandler(ErrorCode.BOOK_CATEGORY_ERROR_001) ;



    }


}
