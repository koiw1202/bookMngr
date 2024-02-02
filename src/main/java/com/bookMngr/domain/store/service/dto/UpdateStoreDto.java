package com.bookMngr.domain.store.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-02        koiw1       최초 생성
 */
@Getter
@Setter
@Builder
public class UpdateStoreDto {

    private long storeCd ;
    private String storeNm ;
    private String address ;
    private BigDecimal latitude ;
    private BigDecimal longitude ;

}
