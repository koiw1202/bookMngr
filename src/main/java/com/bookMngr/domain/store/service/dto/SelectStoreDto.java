package com.bookMngr.domain.store.service.dto;

import com.bookMngr.domain.store.domain.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
@AllArgsConstructor
public class SelectStoreDto {

    private Long storeCd ;
    private String storeNm ;
    private String storeAddress ;
    private BigDecimal storeLatitude ;
    private BigDecimal storeLongitude ;

    public SelectStoreDto(final Store store) {
        this.storeCd = store.getStoreCd() ;
        this.storeNm = store.getStoreNm() ;
        this.storeAddress = store.getAddress() ;
        this.storeLatitude = store.getLatitude() ;
        this.storeLongitude = store.getLongitude() ;

    }

}
