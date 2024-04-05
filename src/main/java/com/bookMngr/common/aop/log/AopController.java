package com.bookMngr.common.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.bookMngr.common.constant.CCConst.ARROW_TO_RIGHT_FOR_LOG;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-22        koiw1       최초 생성
 */
@Component
@Aspect
@Slf4j
public class AopController {

    private final Logging logging ;


    public AopController(Logging logging) {
        this.logging = logging;
    }

    @Pointcut("  execution (* com.bookMngr.domain.auth.controller..*(..))" +
            " || execution (* com.bookMngr.domain.book.controller..*(..))" +
            " || execution (* com.bookMngr.domain.bookCategory.controller..*(..))" +
            " || execution (* com.bookMngr.domain.category.controller..*(..))")
    public void range() {}

    @Around("range()")
    public Object mainController(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.nanoTime() ;
        UUID uuid = UUID.randomUUID() ;

        try {
            logging.logTrace(String.join("", uuid.toString(), ARROW_TO_RIGHT_FOR_LOG, joinPoint.getSignature().toShortString()), true);
            Object ret = joinPoint.proceed() ;
            logging.logTrace(String.join("", uuid.toString(), ARROW_TO_RIGHT_FOR_LOG, joinPoint.getSignature().toShortString()), false);

            long endTime = System.nanoTime() ;

            log.info("PROCESS TIME : {}  ", (endTime - startTime)) ;

            return ret ;

        } catch (Exception e1){
            logging.getTraceLogger().error(e1.getMessage());
            throw e1 ;
        }

    }
}
