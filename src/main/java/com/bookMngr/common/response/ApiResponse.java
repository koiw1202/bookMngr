package com.bookMngr.common.response;

import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

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

    public static HttpEntity ok(String message, Object data) {

        return new HttpEntity(
                ApiResponse.builder()
                        .code(OK_CODE)
                        .status(OK_STATUS)
                        .message(message)
                        .data(data)
                        .build(),
                null
        ) ;
    }

    public static HttpEntity ok(String message, Object data, HttpHeaders headers) {

        return new HttpEntity(
                    ApiResponse.builder()
                               .code(OK_CODE)
                               .status(OK_STATUS)
                               .message(message)
                               .data(data)
                               .build(),
                    headers
        ) ;
    }

    public static ApiResponse fail(String errorMessage) {

        return ApiResponse.builder()
                .code(FAIL_CODE)
                .status(FAIL_STATUS)
                .message(errorMessage)
                .build() ;
    }

    public static HttpEntity fail(ErrorCode errorCode) {

        return new HttpEntity(
                ApiResponse.builder()
                        .code(errorCode.getCode())
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build() ,
                null
        ) ;
    }

    public static HttpEntity fail(ErrorHandler errorHandler) {

        return new HttpEntity(
                ApiResponse.builder()
                        .code(errorHandler.getCode())
                        .status(errorHandler.getStatus())
                        .message(errorHandler.getMessage())
                        .build() ,
                null
        ) ;
    }

}