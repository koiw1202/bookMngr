package com.bookMngr.common.aop.log;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@Slf4j
public class Logging {

    private final LoggerProvider loggerProvider;

    public void logTrace(String message, Boolean isStart) {

        if(isStart)
            log.info(loggerProvider.makeStartLog(message)) ;
        else
            log.info(loggerProvider.makeEndLog(message)) ;
    }
}
