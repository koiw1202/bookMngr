package com.bookMngr.domain.member.controller.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * description    : 회원 정보 변경을 위한 Dto(컨트롤러)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-25        koiw1       최초 생성
 */
@Getter
@Builder
public class ChngMemberInfoDto {

    private String nickNm ;
    private String password ;




}
