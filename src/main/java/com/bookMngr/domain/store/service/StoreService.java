package com.bookMngr.domain.store.service;

import com.bookMngr.domain.store.service.dto.InsertStoreDto;
import com.bookMngr.domain.store.service.dto.UpdateStoreDto;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-30        koiw1       최초 생성
 */
public interface StoreService {

    public Integer enrollStore(final InsertStoreDto insertStoreDto) ;

    public Integer updateStoreInfo(final UpdateStoreDto updateStoreDto) ;

}
