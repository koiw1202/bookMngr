package com.bookMngr.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
@Getter
@AllArgsConstructor
public enum PAYLOAD_TYPE {

    GRADE("userGrade"),
    GRANT("userGrant"),
    USER_CD("userCd")

    ;

    private String name ;

}
