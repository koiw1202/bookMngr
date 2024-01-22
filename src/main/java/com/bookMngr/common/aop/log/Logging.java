package com.bookMngr.common.aop.log;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
