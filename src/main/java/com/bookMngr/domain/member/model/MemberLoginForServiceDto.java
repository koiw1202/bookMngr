package com.bookMngr.domain.member.model;

import lombok.Builder;
import lombok.Getter;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-25        koiw1       최초 생성
 */
@Getter
@Builder
public class MemberLoginForServiceDto {

    private String memberId ;
    private String password ;

}
