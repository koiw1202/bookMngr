package com.bookMngr.domain.store.controller;

import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.common.response.ApiResponse;
import com.bookMngr.domain.store.model.EnrollStoreDto;
import com.bookMngr.domain.store.model.UpdateStoreInfoDto;
import com.bookMngr.domain.store.service.StoreService;
import com.bookMngr.domain.store.service.dto.InsertStoreDto;
import com.bookMngr.domain.store.service.dto.UpdateStoreDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.bookMngr.common.constant.CCConst.MERGE_FAIL;
import static com.bookMngr.common.constant.CCConst.OK_CODE_FOR_CUD;
import static com.bookMngr.common.error.ErrorCode.STORE_ERROR_001;
import static com.bookMngr.common.error.ErrorCode.STORE_ERROR_002;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-22        koiw1       최초 생성
 */
@RestController("/v1/store")
public class StoreController {

    private final StoreService storeService ;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @Operation(summary = "매장등록" , description = "매장등록 API")
    @PostMapping("/bo/manager/store")
    public HttpEntity enrollStore(@RequestBody final EnrollStoreDto enrollStoreDto) throws ErrorHandler {

        Integer result = storeService.enrollStore(InsertStoreDto.builder()
                .storeNm(enrollStoreDto.getStoreNm())
                .longitude(enrollStoreDto.getLongitude())
                .latitude(enrollStoreDto.getLatitude())
                .address(enrollStoreDto.getAddress())
                .build()
        ) ;

        return Optional.ofNullable(result)
                .filter((r) -> r == OK_CODE_FOR_CUD)
                .map((r) -> ApiResponse.ok(CCConst.MERGE_SUCCESS, null))
                .orElseThrow(() -> new ErrorHandler(STORE_ERROR_001, MERGE_FAIL)) ;
    }

    @Operation(summary = "매장 변경" , description = "매장변경 API")
    @PutMapping("/bo/manager/store")
    public HttpEntity updateStoreInfo(@RequestBody final UpdateStoreInfoDto updateStoreInfoDto) throws ErrorHandler {

        Integer result = storeService.updateStoreInfo(UpdateStoreDto.builder()
                .storeCd(updateStoreInfoDto.getStoreCd())
                .storeNm(updateStoreInfoDto.getStoreNm())
                .latitude(updateStoreInfoDto.getLatitude())
                .longitude(updateStoreInfoDto.getLongitude())
                .address(updateStoreInfoDto.getAddress())
                .build()) ;

        return Optional.ofNullable(result)
                .filter((r) -> r == OK_CODE_FOR_CUD)
                .map((r) -> ApiResponse.ok(CCConst.MERGE_SUCCESS, null))
                .orElseThrow(() -> new ErrorHandler(STORE_ERROR_002, MERGE_FAIL)) ;
    }


}











