package com.bookMngr.common.jwt;

import com.bookMngr.common.jwt.vo.PayloadVo;
import com.bookMngr.common.jwt.vo.TokenVO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static java.sql.Timestamp.valueOf;

/**
 * description    : 토큰 발행을 수행하는 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Component
public class TokenFactory {

    private final long expiredMinute ;
	private final Integer refreshDays ;
	private final Key secretKey ;
    Map<String, Object> headers = new HashMap<>() ;

    private TokenFactory(@Value("${jwt.expiredMinute}") long expiredMinute,
                         @Value("${jwt.secret}") String secret,
                         @Value("${jwt.refreshDays}") Integer refreshDays ) {
        this.expiredMinute = expiredMinute;
        this.refreshDays = refreshDays ;
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret)) ;

        headers.put("type", "JWT") ;
        headers.put("alg", "HS256") ;
    }

    public TokenVO issueAllToken(final PayloadVo payloadVo) {

        Map<String, Object> payloads = new HashMap<>();
        payloads.put("userCd", payloadVo.getUserCd()) ;
        payloads.put("userGrant", payloadVo.getUserGrant()) ;
        payloads.put("userGrade", payloadVo.getUserGrade()) ;

        return TokenVO.builder()
                .accessToken(this.createToken(payloads, LocalDateTime.now().plusMinutes(expiredMinute)))
                .refreshToken(this.createToken(payloads, LocalDateTime.now().plusDays(refreshDays)))
                .build() ;
    }

    private String createToken(final Map<String, Object> payloads, final LocalDateTime date) {
        return Jwts.builder()
                .setHeader(headers)  // Headers 설정
                .setClaims(payloads) // Claims 설정
                .setSubject("User's jwt for Authorization") // 토큰 용도
                .setExpiration(valueOf(date)) // 토큰 만료 시간 설정
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact() ; // 토큰 생성
    }
}