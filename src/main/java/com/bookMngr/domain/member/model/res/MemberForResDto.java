package com.bookMngr.domain.member.model.res;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Getter
@Builder
public class MemberForResDto {

    private String nickNm ;
    private Timestamp regerDt ;

}
