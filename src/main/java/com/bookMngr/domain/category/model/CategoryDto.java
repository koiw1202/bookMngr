package com.bookMngr.domain.category.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import static com.bookMngr.common.error.ErrorMessage.MSG_CATEGORY_ERROR_001;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotBlank(message = MSG_CATEGORY_ERROR_001)
    @Schema(name = "categoryNm" , description = "카테고리명" , example = "문학" , required = true)
    private String categoryNm ;

    

}
