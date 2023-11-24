package com.bookMngr.common.auth.vo;

import lombok.*;

/**
 * description    : 유저의 정보를 담는 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-24        koiw1       최초 생성
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthVO {

    private String userGrade ;
    private String userGrant ;
    private String userCd ;

}
