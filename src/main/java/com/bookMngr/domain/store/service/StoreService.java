package com.bookMngr.domain.store.service;

import com.bookMngr.domain.store.model.StoreInfoDto;
import com.bookMngr.domain.store.service.dto.InsertStoreDto;
import com.bookMngr.domain.store.service.dto.SelectStoreDto;
import com.bookMngr.domain.store.service.dto.UpdateStoreDto;

import java.util.List;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-30        koiw1       최초 생성
 */
public interface StoreService {

    Integer enrollStore(final InsertStoreDto insertStoreDto) ;
    Integer updateStoreInfo(final UpdateStoreDto updateStoreDto) ;
    List<SelectStoreDto> getStoreList(final StoreInfoDto storeInfoDto) ;

}
