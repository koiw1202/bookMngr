package com.bookMngr.domain.auth.model;

import lombok.Builder;
import lombok.Getter;

/**
 * description    : Controller로부터 받은 페이로드 정보를 담는 클레스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-23        koiw1       최초 생성
 */
@Getter
@Builder
public class PayloadDto {
    private String userGrade ;
    private String userGrant ;
    private String userCd ;
}
