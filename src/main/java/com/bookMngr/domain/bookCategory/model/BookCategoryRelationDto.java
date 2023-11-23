package com.bookMngr.domain.bookCategory.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * packageName    : com.bookMngr.relation.bookCategory.model
 * fileName       : BookCategoryRelationDto
 * author         : FIC08709
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        FIC08709       최초 생성
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCategoryRelationDto {

    @NotNull
    @Schema(name = "bookId" , description = "책 ID" , example = "1" , required = true)
    private long bookId ;

    @NotNull
    @Schema(name = "categoryId" , description = "카테고리 ID" , example = "1" , required = true)
    private long categoryId ;

}
