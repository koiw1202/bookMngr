package com.bookMngr.domain.store.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-22        koiw1       최초 생성
 */
@RestController("/v1/store")
public class StoreController {

    @Operation(summary = "매장등록" , description = "매장등록 API")
    @PostMapping("/bo/manager/store")
    public String enrollStore() {
        System.out.println("매장등록 실행") ;
        return null ;
    }



}
