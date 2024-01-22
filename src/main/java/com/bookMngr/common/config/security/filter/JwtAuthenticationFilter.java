package com.bookMngr.common.config.security.filter;

import com.bookMngr.common.auth.UserAuthHolderService;
import com.bookMngr.common.auth.UserAuthProvider;
import com.bookMngr.common.code.PAYLOAD_TYPE;
import com.bookMngr.common.config.header.HeaderInfoProvider;
import com.bookMngr.common.error.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * description    : 회원의 JWT 정보를 담는 Filter 추가
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
@Slf4j
public final class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final UserAuthProvider userAuthProvider ;
    private final UserAuthHolderService userAuthHolderService ;

    public JwtAuthenticationFilter(UserAuthProvider userAuthProvider, UserAuthHolderService userAuthHolderService) {
        this.userAuthProvider = userAuthProvider;
        this.userAuthHolderService = userAuthHolderService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String accessToken = HeaderInfoProvider.extractAccessToken(request) ;

        if(accessToken != null && !accessToken.isEmpty()) {

//          ThreadLocal에 저장
            userAuthHolderService.addUserInfo(accessToken) ;

//          contextHolder에 저장
            this.setSecurityContextHolder() ;

        }

        filterChain.doFilter(request , response) ;

    }

    private void setSecurityContextHolder() {

        List<SimpleGrantedAuthority> roles = Arrays.asList(new SimpleGrantedAuthority(String.join("_", "ROLE", userAuthProvider.getUserInfo(PAYLOAD_TYPE.GRANT)))) ;

        UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                userAuthProvider.getUserInfo(PAYLOAD_TYPE.USER_CD),
                null,
                roles
        ) ;

        SecurityContextHolder.getContext().setAuthentication(upat) ;
    }


}








