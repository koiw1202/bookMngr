package com.bookMngr.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-25        koiw1       최초 생성
 */
@AllArgsConstructor
@Getter
public enum MemberGradeType {

    WELCOME_LEVEL("01", "초심자"),
    GREEN_LEVEL("02", "중급자"),
    GOLD_LEVEL("03", "고급자")

    ;
    private String code ;
    private String name ;

}
