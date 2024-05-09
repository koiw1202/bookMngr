package com.bookMngr.common.response;

import com.bookMngr.common.constant.CCConst;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static com.bookMngr.common.constant.CCConst.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
final public class ApiResponse <T> {

    private int status ;
    private String code ;
    private String message ;
    private T data ;

    public static ResponseEntity ok(String message, Object data) {

        return new ResponseEntity(
                ApiResponse.builder()
                        .code(OK_CODE)
                        .status(OK_STATUS)
                        .message(message)
                        .data(data)
                        .build(),
                null
        ) ;
    }

    public static ResponseEntity ok(String message, Object data, HttpHeaders headers) {
        return new ResponseEntity(ApiResponse.builder()
                .code(OK_CODE)
                .status(OK_STATUS)
                .message(message)
                .data(data)
                .build(), headers, OK_STATUS) ;
    }

    public static ResponseEntity fail(String errorMessage) {

        return new ResponseEntity(ApiResponse.builder()
                .code(FAIL_CODE)
                .status(FAIL_STATUS)
                .message(errorMessage)
                .build(),
                null,
                FAIL_STATUS
        ) ;
    }

    public static ResponseEntity fail(ErrorCode errorCode) {

        return new ResponseEntity(
                ApiResponse.builder()
                        .code(errorCode.getCode())
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build() ,
                null,
                FAIL_STATUS
        ) ;
    }

    public static ResponseEntity fail(ErrorHandler errorHandler) {

        return new ResponseEntity(
                ApiResponse.builder()
                        .code(errorHandler.getCode())
                        .status(errorHandler.getStatus())
                        .message(errorHandler.getMessage())
                        .build() ,
                null,
                errorHandler.getStatus()
        ) ;
    }
}