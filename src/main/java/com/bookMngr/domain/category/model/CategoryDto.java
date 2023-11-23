package com.bookMngr.domain.category.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;

import static com.bookMngr.common.error.ErrorMessage.* ;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotBlank(message = MSG_CATEGORY_ERROR_001)
    @Schema(name = "categoryNm" , description = "카테고리명" , example = "문학" , required = true)
    private String categoryNm ;

}
