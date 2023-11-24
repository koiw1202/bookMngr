package com.bookMngr.common.config.security.filter;

import com.bookMngr.common.auth.UserAuthHolderService;
import com.bookMngr.common.auth.UserAuthProvider;
import com.bookMngr.common.error.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * description    : 회원의 JWT 정보를 담는 Filter 추가
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
@Slf4j
public final class JwtAuthenticationFilter extends GenericFilterBean {

    private final UserAuthProvider userAuthProvider ;
    private final UserAuthHolderService userAuthHolderService ;

    public JwtAuthenticationFilter(UserAuthProvider userAuthProvider, UserAuthHolderService userAuthHolderService) {
        this.userAuthProvider = userAuthProvider;
        this.userAuthHolderService = userAuthHolderService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request ;
        HttpServletResponse httpResponse = (HttpServletResponse) response ;

        log.info("reqeustUrl : {}", httpRequest.getRequestURL().toString()) ;

        try {
            userAuthHolderService.addUserInfo(httpRequest.getHeader("x-access-token")) ;
        } catch(ExpiredJwtException e1) {
            ErrorResponse.setUnauthorizedResponse(httpResponse) ;
        } catch(SignatureException e2) {
            ErrorResponse.setUnauthorizedResponse(httpResponse) ;
        }

        chain.doFilter(request , httpResponse) ;
    }

}
