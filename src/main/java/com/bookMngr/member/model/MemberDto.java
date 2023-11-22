package com.bookMngr.member.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * packageName    : com.bookMngr.member.model
 * fileName       : MemberDto
 * author         : FIC08709
 * date           : 2023-11-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-22        FIC08709       최초 생성
 */
@Getter
@Builder
public class MemberDto {

    private String memberId ;
    private String nickNm ;
    private String unregYn ;
    private String rstYn ;

}
