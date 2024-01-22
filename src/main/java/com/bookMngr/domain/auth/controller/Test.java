package com.bookMngr.domain.auth.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-22        koiw1       최초 생성
 */
@RestController
public class Test {

    @GetMapping("/test")
    public HttpEntity test() {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>() ;

        multiValueMap.add("accessToken", "test1") ;
        multiValueMap.add("refreshToken", "test2") ;
        HttpEntity httpEntity = new HttpEntity(
                                        "TEST",
                                        new HttpHeaders(multiValueMap)
                                ) ;

        return httpEntity ;
    }



}
