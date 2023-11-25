package com.bookMngr.domain.member.model.res;

import lombok.Builder;
import lombok.Getter;

/**
 * description    : 로그인 이후 view에 보여줄 유저의 정보를 가진 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-25        koiw1       최초 생성
 */
@Builder
public class MemberInfoAfterLoginDto {

    private String nickNm ;

}
