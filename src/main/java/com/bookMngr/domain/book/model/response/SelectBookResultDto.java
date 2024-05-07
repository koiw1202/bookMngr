package com.bookMngr.domain.book.model.response;

import lombok.*;

/**
 * packageName    : com.bookMngr.book.model.response
 * fileName       : SelectBookResultDto
 * author         : FIC08709
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        FIC08709       최초 생성
 */

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SelectBookResultDto {

    private String bookId ;
    private String writer ;
    private String title ;
    private String categoryId ;
    private String categoryNm ;

}
