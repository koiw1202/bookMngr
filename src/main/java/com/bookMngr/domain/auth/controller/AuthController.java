package com.bookMngr.domain.auth.controller;

import com.bookMngr.common.jwt.vo.TokenVO;
import com.bookMngr.common.response.ApiResponse;
import com.bookMngr.domain.auth.model.PayloadDto;
import com.bookMngr.domain.auth.model.UserAuthInfoDto;
import com.bookMngr.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bookMngr.common.constant.CCConst.ISSUE_TOKEN_SUCCESS;

/**
 * description    : 인증과 관련된 API를 제공하는 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService ;


    @PostMapping("/v1.0.0/auth/token")
    public HttpEntity permitLogin(final UserAuthInfoDto userAuthInfoDto) {

        TokenVO tokenVO = authService.getToken(
                        PayloadDto.builder()
                                .userCd(userAuthInfoDto.getUserCd())
                                .userGrade(userAuthInfoDto.getUserGrade())
                                .userGrant(userAuthInfoDto.getUserGrant())
                                .build()
        ) ;
        HttpEntity httpEntity = new HttpEntity(null, new HttpHeaders(){{
            add("accessToken", tokenVO.getAccessToken());
            add("refreshToken", tokenVO.getRefreshToken());
        }
        }) ;

        return ApiResponse.ok(ISSUE_TOKEN_SUCCESS, null,  new HttpHeaders(){{
                add("accessToken", tokenVO.getAccessToken());
                add("refreshToken", tokenVO.getRefreshToken());
            }
        }) ;
    }

}
