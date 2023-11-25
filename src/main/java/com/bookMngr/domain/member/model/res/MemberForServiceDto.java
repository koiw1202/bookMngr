package com.bookMngr.domain.member.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.bookMngr.member.model
 * fileName       : MemberDtoForService
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
@AllArgsConstructor
@NoArgsConstructor
public class MemberForServiceDto {

    private String memberId ;
    private String password ;
    private String nickNm ;
    private String unregYn ;
    private String rstYn ;
    private String phoneNumber ;

}
