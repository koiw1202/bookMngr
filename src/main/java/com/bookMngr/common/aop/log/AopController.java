package com.bookMngr.common.aop.log;

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
@Aspect
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
    public void mainController(ProceedingJoinPoint joinPoint) {

        try {
            logging.logTrace(joinPoint.getSignature().toShortString(), true);
            joinPoint.proceed() ;
            logging.logTrace(joinPoint.getSignature().toShortString(), false);

        } catch (Exception e1){
            logging.getTraceLogger().error(e1.getMessage());

        } catch (Throwable e2) {
            logging.getTraceLogger().error(e2.getMessage());

        }


    }
}
