package com.bookMngr.domain.store.service;

import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.domain.store.domain.Store;
import com.bookMngr.domain.store.model.StoreInfoDto;
import com.bookMngr.domain.store.repository.StoreRepository;
import com.bookMngr.domain.store.service.dto.InsertStoreDto;
import com.bookMngr.domain.store.service.dto.SelectStoreDto;
import com.bookMngr.domain.store.service.dto.UpdateStoreDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bookMngr.common.constant.CCConst.FAIL_CODE_FOR_CUD;
import static com.bookMngr.common.constant.CCConst.OK_CODE_FOR_CUD;

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
    public Integer enrollStore(final InsertStoreDto insertStoreDto) {

        Store result = storeRepository.save(Store.builder()
                .storeNm(insertStoreDto.getStoreNm())
                .address(insertStoreDto.getAddress())
                .latitude(insertStoreDto.getLatitude())
                .longitude(insertStoreDto.getLongitude())
                .build()) ;

        return Optional.ofNullable(result)
                .map(r -> OK_CODE_FOR_CUD)
                .orElse(FAIL_CODE_FOR_CUD) ;
    }

    @Override
    public Integer updateStoreInfo(final UpdateStoreDto updateStoreDto) {

        Store updateStoreResult = storeRepository.save(Store.builder()
                .storeCd(updateStoreDto.getStoreCd())
                .address(updateStoreDto.getAddress())
                .storeNm(updateStoreDto.getStoreNm())
                .latitude(updateStoreDto.getLatitude())
                .longitude(updateStoreDto.getLongitude())
                .build()
        ) ;

        return Optional.ofNullable(updateStoreResult)
                .map(v -> OK_CODE_FOR_CUD)
                .orElse(FAIL_CODE_FOR_CUD) ;
    }

    @Override
    public List<SelectStoreDto> getStoreList(final StoreInfoDto storeInfoDto) {

        List<Store> storeList = storeRepository.selectStore(storeInfoDto) ;

        return storeList.stream().map(v -> new SelectStoreDto(v))
                .collect(Collectors.toList()) ;

    }
}