package com.bookMngr.domain.auth.model;

import lombok.Builder;
import lombok.Getter;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Getter
@Builder
public class UserAuthInfoDto {
    private String userGrade ;
    private String userGrant ;
    private String userCd ;
}
