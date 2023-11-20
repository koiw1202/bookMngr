package com.bookMngr.book.model.response;

import com.bookMngr.book.domain.Book;
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
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SelectBookResultDto {

    private String writer ;
    private String title ;
    private String categoryNm ;


}
