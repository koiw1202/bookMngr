package com.bookMngr.domain.bookStore.service.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-12        koiw1       최초 생성
 */
@Builder
@Getter
public class BookStoreQuantityInfoDto {

    private Long storeCd ;
    private String storeNm ;
    private String address ;
    private BigDecimal latitude ;
    private BigDecimal longitude ;
    private Long bookQuantity ;

    private List<BookInfoDto> bookInfoDtos = new ArrayList<>() ;


}
