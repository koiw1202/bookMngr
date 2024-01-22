package com.bookMngr.domain.auth.controller;

import com.bookMngr.common.jwt.vo.TokenVO;
import com.bookMngr.domain.auth.model.PayloadDto;
import com.bookMngr.domain.auth.model.UserAuthInfoDto;
import com.bookMngr.domain.auth.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * description    : 인증과 관련된 API를 제공하는 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@RestController
@Slf4j
public class AuthController {

    private final AuthService authService ;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/v1.0.0/auth/token")
    public HttpEntity permitLogin(@Valid @RequestBody final UserAuthInfoDto userAuthInfoDto) {

        TokenVO tokenVO = authService.getToken(
            PayloadDto.builder()
                    .memberCd(userAuthInfoDto.getMemberCd())
                    .memberGrade(userAuthInfoDto.getMemberGrade())
                    .memberGrant(userAuthInfoDto.getMemberGrant())
                    .build()
        ) ;



        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>() ;

        multiValueMap.add("accessToken", tokenVO.getAccessToken()) ;
        multiValueMap.add("refreshToken", tokenVO.getRefreshToken()) ;
        HttpEntity httpEntity = new HttpEntity(
                                        null,
                                        new HttpHeaders(multiValueMap)
                                ) ;

        return httpEntity ;



//        return ApiResponse.ok(ISSUE_TOKEN_SUCCESS, null,  new HttpHeaders(multiValueMap)) ;
    }

}
