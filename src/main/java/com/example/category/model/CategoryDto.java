package com.example.category.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static com.example.common.error.ErrorMessage.* ;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotBlank(message = CATEGORY_ERROR_001)
    @Schema(name = "categoryNm" , description = "카테고리명" , example = "문학" , required = true)
    private String categoryNm ;

}
