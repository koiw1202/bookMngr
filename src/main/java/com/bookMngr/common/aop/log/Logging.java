package com.bookMngr.common.aop.log;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-22        koiw1       최초 생성
 */
@Component
@AllArgsConstructor
@Getter
@Log4j2
public class Logging {

    private final LoggerProvider loggerProvider;

    public void logTrace(String message, Boolean isStart) {

        if(isStart)
            log.info(loggerProvider.makeStartLog(message)) ;
        else
            log.info(loggerProvider.makeEndLog(message)) ;
    }
}
