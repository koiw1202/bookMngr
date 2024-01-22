package com.bookMngr.domain.store.model;

import lombok.Getter;
import lombok.Setter;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-22        koiw1       최초 생성
 */
@Getter
@Setter
public class StoreDto {

    private String storeNm ;
    private String address ;
    private long latitude ;
    private long longitude ;

}
