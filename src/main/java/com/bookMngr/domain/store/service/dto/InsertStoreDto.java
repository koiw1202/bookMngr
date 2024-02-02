package com.bookMngr.domain.store.service.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-22        koiw1       최초 생성
 */
@Getter
@Builder
public class InsertStoreDto {

    private String storeNm ;
    private String address ;
    private BigDecimal latitude ;
    private BigDecimal longitude ;

}
