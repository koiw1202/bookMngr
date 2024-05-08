package com.bookMngr.common.aop.log;

import lombok.extern.log4j.Log4j2;
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
@Log4j2
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
        try {
            logging.logTrace(joinPoint.getSignature().toShortString(), true);
            Object ret = joinPoint.proceed() ;
            logging.logTrace(joinPoint.getSignature().toShortString(), false);

            return ret ;

        } catch (Exception e1){
            log.error(e1.getMessage());
            throw e1 ;
        }

    }
}
