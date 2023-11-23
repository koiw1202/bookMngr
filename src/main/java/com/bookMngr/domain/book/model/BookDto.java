package com.bookMngr.domain.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDto {

    @NonNull
    @Schema(name = "writer", description = "작가", example = "김성훈", required = true)
    private String writer ;

    @NonNull
    @Schema(name = "title",  description = "책 제목" , example = "JPA 기본서", required = true)
    private String title ;

    @NonNull
    @Schema(name = "categoryId",  description = "카테고리" , example = "1", required = true)
    private long categoryId ;

}
