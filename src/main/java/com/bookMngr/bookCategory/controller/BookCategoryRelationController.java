package com.bookMngr.bookCategory.controller;

import com.bookMngr.bookCategory.model.BookCategoryRelationDto;
import com.bookMngr.bookCategory.service.BookCategoryRelationService;
import com.bookMngr.common.CCConst;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
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
    @PutMapping(name = "/bookCategoryRelation")
    public ApiResponse updateBookCategoryRelation(BookCategoryRelationDto bookCategoryRelationDto) throws ErrorHandler {

        if(bookCategoryRelationService.updateBookCategoryRelation(bookCategoryRelationDto))
            return ApiResponse.ok(CCConst.MERGE_SUCCESS) ;

        else
            throw new ErrorHandler(ErrorCode.BOOK_CATEGORY_ERROR_001) ;



    }


}
