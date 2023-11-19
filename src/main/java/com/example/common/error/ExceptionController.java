package com.example.common.error;

import com.example.common.response.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class ExceptionController {

    @ExceptionHandler({ErrorHandler.class})
    public ApiResponse handleException(ErrorHandler errorHandler) {

        log.info("ErrorHandler ---> {}", errorHandler) ;

        return ApiResponse.fail(errorHandler.getMessage()) ;

    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ApiResponse handleException(MethodArgumentNotValidException exception) {

        log.info("MethodArgumentNotValidException ---> {}", exception.getMessage()) ;

        return ApiResponse.fail(exception.getMessage()) ;
    }

}
