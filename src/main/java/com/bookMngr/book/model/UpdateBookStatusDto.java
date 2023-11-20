package com.bookMngr.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * packageName    : com.bookMngr.book.model
 * fileName       : UpdateBookStatusDto
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookStatusDto {

    @NonNull
    @Schema(name = "bookId", description = "책 Id", example = "1", required = true)
    private Long bookId ;

    @NonNull
    @Schema(name = "bookStatusCd", description = "책 상태코드(01 : 정상 // 02 : 훼손 // 03 : 분실 // 04 : 대여중)", example = "01", required = true)
    private String bookStatusCd ;

}
