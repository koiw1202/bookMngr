package com.bookMngr.common.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;

/**
 * description    : 토큰의 key 값 초기화와 유효성 검사를 수행하는 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Component
@Slf4j
public class TokenManagement {

    private final Key secretKey ;

    public TokenManagement(@Value("${jwt.secret}") final String secret ) {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    /**
     * JWT의 유효성 체크
     */
    public boolean validationCheckToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            log.info("-----> Token Validation Fail {}", e.getMessage()) ;
            return false;
        }
    }

}
