package com.bookMngr.domain.store.repository;

import com.bookMngr.domain.store.domain.Store;
import com.bookMngr.domain.store.model.StoreInfoDto;

import java.util.List;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-30        koiw1       최초 생성
 */
public interface StoreRepsitoryCustom {

    Long updateStore(final Store store) ;
    List<Store> selectStore(final StoreInfoDto storeInfoDto) ;

}
