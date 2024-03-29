package com.bookMngr.domain.store.controller;

import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.error.ErrorHandler;
import com.bookMngr.common.response.ApiResponse;
import com.bookMngr.domain.store.model.EnrollStoreDto;
import com.bookMngr.domain.store.model.StoreInfoDto;
import com.bookMngr.domain.store.model.UpdateStoreInfoDto;
import com.bookMngr.domain.store.service.StoreService;
import com.bookMngr.domain.store.service.dto.InsertStoreDto;
import com.bookMngr.domain.store.service.dto.SelectStoreDto;
import com.bookMngr.domain.store.service.dto.UpdateStoreDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.bookMngr.common.constant.CCConst.*;
import static com.bookMngr.common.error.ErrorCode.*;

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

    @Operation(summary = "매장 조회" , description = "매장조회 API")
    @GetMapping("/bo/manager/store")
    @Parameters(value = {
             @Parameter(name = "storeCd" , description = "매장코드" , example = "1")
            ,@Parameter(name = "storeNm" , description = "매장명" , example = "명동지점")
            ,@Parameter(name = "storeAddress" , description = "매장주소" , example = "서울시")
            ,@Parameter(name = "latitude" , description = "매장위도" , example = "1")
            ,@Parameter(name = "longitude" , description = "매장경도" , example = "1")
            ,@Parameter(name = "pageNo" , description = "현재 페이지" , example = "1", required = true)
            ,@Parameter(name = "pageSize" , description = "페이지 크기" , example = "10", required = true)

    })
    public HttpEntity getStoreList(@RequestParam(required = false) final Long storeCd,
                                   @RequestParam(required = false) final String storeNm,
                                   @RequestParam(required = false) final String storeAddress,
                                   @RequestParam(required = false) final BigDecimal latitude,
                                   @RequestParam(required = false) final BigDecimal longitude,
                                   @RequestParam final Integer pageNo,
                                   @RequestParam final Integer pageSize) throws ErrorHandler {

        List<SelectStoreDto> storeList  =
                storeService.getStoreList(StoreInfoDto.builder()
                                .storeCd(storeCd)
                                .storeNm(storeNm)
                                .storeAddress(storeAddress)
                                .storeLatitude(latitude)
                                .storeLongitude(longitude)
                                .pageNo(pageNo)
                                .pageSize(pageSize)
                                .build()) ;

        return Optional.ofNullable(storeList).filter(v -> !v.isEmpty())
                .map(v -> ApiResponse.ok(SELECT_SUCCESS, v))
                .orElseThrow(() -> new ErrorHandler(STORE_ERROR_003, SELECT_FAIL)) ;
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

    @Operation(summary = "매장 삭제" , description = "매장삭제 API")
    @DeleteMapping("/bo/manager/store/{storeCd}")
    public HttpEntity DeleteStoreInfo(@PathVariable Long storeCd) throws ErrorHandler {

        Integer deleteResult = storeService.deleteStore(storeCd) ;

        return Optional.ofNullable(deleteResult)
                .filter((d) -> d == OK_CODE_FOR_CUD)
                .map((d) -> ApiResponse.ok(CCConst.DELETE_SUCCESS, null))
                .orElseThrow(() -> new ErrorHandler(STORE_ERROR_004)) ;
    }
}











