package com.bookMngr.common.jwt;

import com.bookMngr.common.jwt.vo.PayloadVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.Payload;
import java.security.Key;
import java.util.Map;

/**
 * description    : 토큰의 key 값 초기화와 유효성 검사를 수행하는 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Component
@Slf4j
public class TokenManagement extends TokenValidation{

    public TokenManagement(@Value("${jwt.secret}") final String secret ) {
        super(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret)));
    }

    /**
     * JWT의 유효성 체크
     */
    public boolean validationCheckToken(String token) {
        try{
            super.parsingJwt(token) ;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * JWT의 페이로드 영역을 vo로 객체로 변환해주는 메소드
     */
    public PayloadVo jwtToPayload(String token) {

        Jws<Claims> jwts = super.parsingJwt(token);

        Map<String, Object> payloadMap = jwts.getBody() ;

        return PayloadVo.builder()
                .memberGrade(String.valueOf(payloadMap.get("userGrade")))
                .memberGrant(String.valueOf(payloadMap.get("userGrant")))
                .memberCd(String.valueOf(payloadMap.get("userCd")))
                .build();
    }

}
















