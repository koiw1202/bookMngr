package com.example.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public enum ErrorCode {

     ACCESS_DENIED(403, "403", "접근권한이 없습니다.", "")
    ,EXIST_ID(200, "EC0001", "이미 존재하는 아이디입니다.", "아이디 중복")

    ;

    private Integer status ;
    private String code ;
    private String message ;
    private String internalMessage ;


}
