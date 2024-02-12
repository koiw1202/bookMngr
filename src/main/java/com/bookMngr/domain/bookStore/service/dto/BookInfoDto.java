package com.bookMngr.domain.bookStore.service.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-12        koiw1       최초 생성
 */
@Getter
@Builder
public class BookInfoDto {

    private long bookId ;
    private String writer ;
    private String title ;

}
