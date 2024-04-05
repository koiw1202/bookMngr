package com.bookMngr.common.aop.log;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.UUID;

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
public class Logging {

    private final Logger traceLogger = LogManager.getLogger("TRACE") ;
    private final LoggerProvider loggerProvider;

    public void logTrace(String message, Boolean isStart) {

        if(isStart)
            traceLogger.info(loggerProvider.makeStartLog(message)) ;
        else
            traceLogger.info(loggerProvider.makeEndLog(message)) ;


    }


}
