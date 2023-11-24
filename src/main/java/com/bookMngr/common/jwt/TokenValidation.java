package com.bookMngr.common.jwt;

import com.bookMngr.common.error.ErrorResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.security.Key;

/**
 * description    : 토큰의 유효성을 검증해주는 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
public class TokenValidation {

    private final Key secretKey ;

    public TokenValidation(final SecretKey secretKey) {
        this.secretKey = secretKey ;
    }

    /**
     * JWT를 파싱해주는 메소드
     */
    protected Jws<Claims> parsingJwt(String token) {

        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);

    }

}
