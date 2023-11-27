package com.bookMngr.common.jwt.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Getter
@Builder
@ToString
public class PayloadVo {

    private String memberGrade ;
    private String memberGrant ;
    private String memberCd ;


}
