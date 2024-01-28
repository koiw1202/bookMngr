package com.bookMngr.common.aop.log;

import org.springframework.stereotype.Component;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-22        koiw1       최초 생성
 */
@Component
public class LoggerProvider {

    private final String right = "[start-Log]-------------------->" ;
    private final String left = "[end-Log]-------------------->" ;

    protected String makeStartLog(String message) {
        StringBuilder sb = new StringBuilder() ;
        sb.append(right).append(message) ;

        return sb.toString() ;
    }

    protected String makeEndLog(String message) {
        StringBuilder sb = new StringBuilder() ;
        sb.append(left).append(message) ;

        return sb.toString() ;

    }

}
