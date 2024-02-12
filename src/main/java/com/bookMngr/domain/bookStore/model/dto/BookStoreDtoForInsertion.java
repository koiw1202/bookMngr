package com.bookMngr.domain.bookStore.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-12        koiw1       최초 생성
 */
@Getter
@Setter
@ToString
public class BookStoreDtoForInsertion {

    private Long storeCd ;
    private Long bookId ;
    private Long quantity ;

}
