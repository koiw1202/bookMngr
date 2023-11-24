package com.bookMngr.common.error;

import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.response.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import static com.bookMngr.common.constant.CCConst.ARGUMENT_NOT_VALID;

@RestControllerAdvice
@Log4j2
public class ExceptionController {

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public ApiResponse handleException(SQLIntegrityConstraintViolationException errorHandler) {

        log.error("SQLIntegrityConstraintViolationException ---> {}", errorHandler) ;

        return ApiResponse.fail(ErrorMessage.MSG_ERROR_001) ;

    }

    @ExceptionHandler({ErrorHandler.class})
    public HttpEntity handleException(ErrorHandler errorHandler) {

        log.error("ErrorHandler ---> {}", errorHandler) ;

        return ApiResponse.fail(errorHandler) ;

    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public HttpEntity handleException(MethodArgumentNotValidException exception) {

        List<FieldError> fieldError = exception.getFieldErrors() ;

        String errorMessage = Optional.ofNullable(fieldError)
                                      .map(value -> value.get(0).getDefaultMessage())
                                      .orElse(ARGUMENT_NOT_VALID) ;

        log.error("MethodArgumentNotValidException ---> {}", exception.getMessage()) ;

        return ApiResponse.fail(
                ErrorHandler.builder()
                        .status(400)
                        .code(CCConst.FAIL_CODE)
                        .message(errorMessage)
                        .internalMessage("사용자 arg 오류")
                        .build()
        ) ;
    }

}
