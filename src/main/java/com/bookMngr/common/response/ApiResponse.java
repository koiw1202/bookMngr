package com.bookMngr.common.response;

import com.bookMngr.common.code.CommCd;
import com.bookMngr.common.error.ErrorCode;
import com.bookMngr.common.error.ErrorHandler;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
final public class ApiResponse <T> {

    private int status ;
    private String code ;
    private String message ;
    private T data ;

    public static ApiResponse ok(String message) {

        return ApiResponse.builder()
                .code(CommCd.OK_CODE)
                .status(CommCd.OK_STATUS)
                .message(message)
                .build() ;
    }


    public static ApiResponse ok(String message, Object data) {

        return ApiResponse.builder()
                .code(CommCd.OK_CODE)
                .status(CommCd.OK_STATUS)
                .message(message)
                .data(data)
                .build() ;
    }

    public static ApiResponse fail(String message) {

        return ApiResponse.builder()
                .code(CommCd.FAIL_CODE)
                .status(CommCd.FAIL_STATUS)
                .message(message)
                .build() ;
    }

     public static ApiResponse fail(String message, String internalMeesage) {

        return ApiResponse.builder()
                .code(CommCd.FAIL_CODE)
                .status(CommCd.FAIL_STATUS)
                .message(message)
                .build() ;
    }

    public static ApiResponse fail(ErrorCode errorCode) {

        return ApiResponse.builder()
                .code(CommCd.FAIL_CODE)
                .status(errorCode.getStatus())
                .message(errorCode.getMessage())
                .build() ;
    }

    public static ApiResponse fail(ErrorHandler errorHandler) {

        return ApiResponse.builder()
                .code(errorHandler.getCode())
                .status(errorHandler.getStatus())
                .message(errorHandler.getMessage())
                .build() ;
    }
}