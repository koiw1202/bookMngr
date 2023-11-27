package com.bookMngr.domain.member.controller;

import com.bookMngr.common.auth.UserAuthHolderService;
import com.bookMngr.common.auth.UserAuthProvider;
import com.bookMngr.common.restTemplate.ResponseVO;
import com.bookMngr.common.restTemplate.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
@RestController
public class UtilController {

    @Autowired
    UserAuthProvider userAuthProvider ;

    @Autowired
    UserAuthHolderService userAuthHolderService ;

    @Autowired
    RestTemplateUtil restTemplateUtil ;

    @GetMapping("/util")
    public void Test() {
        Map<String, String> body = new HashMap<>(){{
            put("pageNo", String.valueOf(1)) ;
            put("pageSize", String.valueOf(10)) ;
            put("searchType", "00") ;
        }} ;

        HttpEntity entity = new HttpEntity(body) ;

        System.out.println(MultiValueMap.class.isAssignableFrom(ResponseVO.class)) ;

//        messageConverter.canRead(this.responseClass, contentType)

        System.out.println(restTemplateUtil.get("http://localhost:8080/v1.0.0/book", entity, body));

    }

}
