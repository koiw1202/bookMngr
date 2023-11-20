package com.bookMngr.common.error;

import com.bookMngr.common.response.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
@Log4j2
public class ExceptionController {

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public ApiResponse handleException(SQLIntegrityConstraintViolationException errorHandler) {

        log.error("SQLIntegrityConstraintViolationException ---> {}", errorHandler) ;

        return ApiResponse.fail(ErrorMessage.MSG_BOOK_ERROR_001) ;

    }

    @ExceptionHandler({ErrorHandler.class})
    public ApiResponse handleException(ErrorHandler errorHandler) {

        log.error("ErrorHandler ---> {}", errorHandler) ;

        return ApiResponse.fail(errorHandler) ;

    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ApiResponse handleException(MethodArgumentNotValidException exception) {

        log.error("MethodArgumentNotValidException ---> {}", exception.getMessage()) ;

        return ApiResponse.fail(exception.getMessage()) ;
    }

}
