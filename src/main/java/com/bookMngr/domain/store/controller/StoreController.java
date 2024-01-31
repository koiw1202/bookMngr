package com.bookMngr.domain.store.controller;

import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.common.response.ApiResponse;
import com.bookMngr.domain.store.model.StoreDto;
import com.bookMngr.domain.store.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
    public Optional<HttpEntity> enrollStore(@RequestBody final StoreDto storeDto) throws ErrorHandler {

        Integer result = storeService.enrollStore(storeDto) ;

        return Optional.ofNullable(result)
                .filter((r) -> r == 1)
                .map((r) -> ApiResponse.ok(CCConst.MERGE_SUCCESS, null)) ;
    }



}
