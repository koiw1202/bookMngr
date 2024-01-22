package com.bookMngr.common.config.header;

import javax.servlet.http.HttpServletRequest;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-22        koiw1       최초 생성
 */
public class HeaderInfoProvider {

    public static String extractAccessToken(HttpServletRequest request) {
        return request.getHeader("x-access-token") ;
    }

    public static String extractRefreshToken(HttpServletRequest request) {
        return request.getHeader("x-refresh-token") ;
    }
}
