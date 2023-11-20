package com.bookMngr.book.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * packageName    : com.bookMngr.book.model
 * fileName       : SelectBookDto
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
public class SelectBookDto {

    private Integer pageNo ;
    private Integer pageSize ;
    private String searchType ;
    private String writer ;
    private String title ;
    private Long categoryId ;

}

