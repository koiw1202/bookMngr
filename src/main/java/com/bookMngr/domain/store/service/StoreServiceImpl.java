package com.bookMngr.domain.store.service;

import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.domain.store.domain.Store;
import com.bookMngr.domain.store.model.StoreDto;
import com.bookMngr.domain.store.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-30        koiw1       최초 생성
 */
@Slf4j
@Service

public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository ;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {ErrorHandler.class, Exception.class})
    public Integer enrollStore(final StoreDto storeDto) {

        Store result = storeRepository.save(Store.builder()
                .storeNm(storeDto.getStoreNm())
                .address(storeDto.getAddress())
                .latitude(storeDto.getLatitude())
                .longitude(storeDto.getLongitude())
                .build()) ;

        return Optional.ofNullable(result)
                .map(r -> 1)
                .orElseThrow(() -> new ErrorHandler(ErrorCode.STORE_ERROR_001)) ;
    }
}