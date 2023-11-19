package com.example.common.response;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
final public class ApiResponse {

    private int status ;
    private String code ;
    private String message ;

     public static ApiResponse ok(String message) {

        return ApiResponse.builder()
                .code(CommCd.OK_CODE)
                .status(CommCd.OK_STATUS)
                .message(message)
                .build() ;
    }

     public static ApiResponse fail(String message) {

        return ApiResponse.builder()
                .code(CommCd.FAIL_CODE)
                .status(CommCd.FAIL_STATUS)
                .message(message)
                .build() ;
    }
}