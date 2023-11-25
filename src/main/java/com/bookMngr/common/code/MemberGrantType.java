package com.bookMngr.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description    : 각 회원별 권한
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */

@Getter
@AllArgsConstructor
public enum MemberGrantType {

     M("M", "마스터 권한")
    ,C("C", "회사 권한")
    ,S("S", "매장 권한")
    ,U("U", "회원 권한")

    ;

    private String code ;
    private String name ;

}
