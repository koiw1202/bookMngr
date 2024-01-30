package com.bookMngr.domain.store.service;

import com.bookMngr.domain.store.domain.Store;
import com.bookMngr.domain.store.model.StoreDto;
import com.bookMngr.domain.store.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-30        koiw1       최초 생성
 */
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository ;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public long enrollStorel(StoreDto storeDto) {

        Store result = storeRepository.save(Store.builder()
                .storeNm(storeDto.getStoreNm())
                .address(storeDto.getAddress())
                .latitude(storeDto.getLatitude())
                .longitude(storeDto.getLongitude())
                .build());

        log.info("result -> {}", result) ;

        return 0 ;

    }



}
