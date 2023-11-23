package com.bookMngr.common.jwt.vo;

import lombok.Builder;
import lombok.Getter;

/**
 * description    : 토큰의 정보를 가진 VO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Getter
@Builder
public class TokenVO {

    private String accessToken ;
    private String refreshToken ;

}
