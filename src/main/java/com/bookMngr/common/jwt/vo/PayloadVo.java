package com.bookMngr.common.jwt.vo;

import lombok.*;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Getter
@Builder
public class PayloadVo {

    private String userGrade ;
    private String userGrant ;
    private String userCd ;


}
