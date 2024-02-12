package com.bookMngr.domain.store.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-05        koiw1       최초 생성
 */
@Getter
@Builder
@ToString
public class StoreInfoDto {

    private Long storeCd ;
    private String storeNm ;
    private String storeAddress ;
    private BigDecimal storeLatitude ;
    private BigDecimal storeLongitude ;
    private Integer pageNo ;
    private Integer pageSize ;

}
